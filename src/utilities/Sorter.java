package utilities;

import shapes.Shape;

/**
 * A generic sorting class that can sort arrays of Shape objects based on different sorting methods.
 * 
 * @author sukhd
 * @param <T> The type of Shape object to be sorted.
 */
public class Sorter<T extends Shape> {
    private T[] data;
    /**
     * The type of comparison to be used for sorting, could be based on "a" for area, "v" for volume and "h" for height.
     */
    String compareType; //this is going to be used by the comparator
    
    /**
     * The comparator object that will be used for sorting.
     */
    ShapeComp comparator = null;

    /**
     * Constructor that initializes the sorter with an array of Shape objects and a comparison type.
     * @param data the array of objects to be stored
     * @param compareType  the type of comparison is to be used for sorting.
     */
    public Sorter(T[] data, String compareType){
        this.data = data;
        this.compareType = compareType;
        
        /**
         * Create a comparator object based on the comparison type.
         */
        switch(compareType){
            case "a": comparator = new AreaComparator(); break;
            case "v": comparator = new VolumeComparator(); break;
            case "h": comparator = new HeightComparator(); break;
            default: comparator = new HeightComparator(); break;
        }
    }
    /**
     * getter for data
     * @return the sorted array of Shaped Objects.
     */
    public T[] getData() {
        return data;
    }
    
    /**
     * Sorts the array of Shape objects using the selection sort algorithm.
     * This algorithm works by repeatedly finding the minimum element from the unsorted part of the arry
     * and putting it at the beginning of the unsorted part.
     */
    public void selectionSort() {

        for (int i = 0; i < data.length ; i++) {
            T min = this.data[i];//minimum value
            int minIndex = i;//index of the minimum value

            
            //looping through the whole array to see whih element is minimum and putting that in the beginning of the unsorted array.
            for (int j = i + 1; j < data.length; j++) {
                if (comparator.compare(min, data[j]) < 0) {
                    min = data[j];
                    minIndex = j;
                }
            }
//            System.out.println("new loop");
//            System.out.println(i);
//            System.out.println(minIndex);
            //swap the minimum element with the current element.
            swap(i,minIndex);
        }


    }

    
    /**
     * Swaps two elements in the array.
     * 
     * @param i in the index of the first element.
     * @param j in the index of the second element.
     */
    public void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    
    /**
     * Sorts the array of Shape objects using the Bubble sort algorithm.
     * This algorithm works by repeatedly iterating through the array, comparing adjacent elements 
     * and swapping them if they are in the wrong order.
     */
    public void bubbleSort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {


                if (comparator.compare(data[j], data[j + 1]) < 0) {
                    // Swap array[j] and array[j + 1]
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    
    /**
     * Sorts the array of Shape objects using the Insertion sort algorithm.
     * This algorithm works by iterating through the array one element at a time and dividing the array into sorted and unsorted arrays, inserting each element
     * into its proper position in the sorted part of the array by comparing with the elements already present the sorted array.
     */
    public void insertionSort() {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            T key = data[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && comparator.compare(key, data[j]) > 0) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }
    
    /**
     * Sorts the array of Shape objects using the Quick sort algorithm.
     * This algorithm works by selecting a pivot element, partitioning the array around the pivot and sorting values larger than it on one side and smaller
     * to the other side, and then it repeats those steps until the array is sorted.
     */
    public void quickSort() {
        quickSort(0, data.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(data[j], pivot) >= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    
    /**
     * Sorts the array of Shape objects using the merge sort algorithm.
     * 
     * This algorithm works by dividing the array into multiple sub_arrays until each has only one item, them merges those sub_arrays into a array back together.
     */
    public void mergeSort() {
        if (data.length < 2) return;
        mergeSort(0, data.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Shape[] L = new Shape[n1];
        Shape[] R = new Shape[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = data[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = data[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (comparator.compare((T) L[i], (T) R[j]) >= 0) {
                data[k] = (T) L[i];
                i++;
            } else {
                data[k] = (T) R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            data[k] = (T) L[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = (T) R[j];
            j++;
            k++;
        }
    }

    /**
     * Sorts the array of Shape objects using the Gnome sort algorithm.
     * 
     * This algorithm works by iterating through the array, comparing each pair of elements and swapping them
     * if they are in the wrong order.
     */
    public void gnomeSort()
    {
        int n = data.length;
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            if (comparator.compare(data[index], data[index - 1]) < 0) {
                index++;
            }
            else {

                T temp = data[index];
                data[index] = data[index - 1];
                data[index - 1] = temp;
                index--;
            }
        }
        return;
    }

}
