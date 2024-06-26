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
     * Sorts the array of Shape objects using the selection sort algorithm in the descending order.
     * This algorithm works by repeatedly finding the minimum element from the unsorted part of the array
     * and putting it at the beginning of the unsorted part.
     */
    public void selectionSort() {

        for (int i = 0; i < data.length ; i++) {
            T min = this.data[i];//minimum value
            int minIndex = i;//index of the minimum value

            
            //looping through the whole array to see whih element is minimum and putting that in the beginning of the unsorted array.
            for (int j = i + 1; j < data.length; j++) {
                //comparator.compare(min, data[j] < 0) compare min value with value at index j and if it return -1 i.e. data[j] > minimum, it will swap them. Therefore making it in the descending order having larger value at first.
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
     * Sorts the array of Shape objects using the Bubble sort algorithm in the descending order.
     * This algorithm works by repeatedly iterating through the array, comparing adjacent elements 
     * and swapping them if they are in the wrong order.
     */
    public void bubbleSort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                //comparator.compare(data[i], data[j] < 0) compare value at index i with value at index j and if it return -1 i.e. data[j] > data[i], it will swap them. Therefore making it in the descending order having larger values first.
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
     * Sorts the array of Shape objects using the Quick sort algorithm in the descending order.
     * This algorithm works by selecting a pivot element, partitioning the array around the pivot and sorting values larger than it on one side and smaller
     * to the other side, and then it repeats those steps until the array is sorted.
     */
    public void quickSort() {
        quickSort(0, data.length - 1);
    }
    /**
     * takes an array, identifies it first element, last element and partition a one side all smaller elements and on the other all larger elements.
     * @param low the starting index of the current partition.
     * @param high the ending index of current partition.
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            // Partition the array around a pivot element, and get the index of the pivot.
            int pi = partition(low, high);
            //sorts the left partition i.e. elements less than the pivot
            quickSort(low, pi - 1);
            //sorts the right partition i.e. elements greater than the pivot
            quickSort(pi + 1, high);
        }
    }

    /**
     * Partition the array around a pivot element
     * @param low The starting index of the current partition.
     * @param high The ending index of the current partition.
     * @return The index of the pivot element in the final position.
     */
    private int partition(int low, int high) {
        T pivot = data[high]; //choose the pivot element i.e. the last element
        int i = (low - 1);// index of the smaller element
        for (int j = low; j < high; j++) {
            //comparator.compare(data[j], pivot >= 0) compare value at index j with pivot and if it return 1 or 0 i.e. data[j] > pivot , it will swap them. Therefore making it in the descending order having larger values first.
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
        //if the array has less than 2 elements, it is already sorted, so retrun.
        if (data.length < 2) return;
        mergeSort(0, data.length - 1);
    }

    /**
     * Performing merge sort on a portion of the array.
     * 
     * @param left The starting index of the current portion.
     * @param right The ending index of the current portion.
     */
    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; //Calculating middle index
            mergeSort(left, mid); //sort the left half of the current portion.
            mergeSort(mid + 1, right); //sort the right half of the current portion.
            merge(left, mid, right);//merge the sorted left and right halves.
        }
    }

    
    /**
     * Method to merge two sorted portions of the array.
     * 
     * @param left The starting index of the left portion
     * @param mid the ending index of the left portion.
     * @param right the ending index of the right portion.
     */
    private void merge(int left, int mid, int right) {
        //calculate the sizes of the left  and right portions.
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        //Create temporary arrays to hold the left and right portions.
        Shape[] L = new Shape[n1];
        Shape[] R = new Shape[n2];

        //copy the elements from the data array to the temporary arrays.
        for (int i = 0; i < n1; ++i)
            L[i] = data[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = data[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        
        //Merge the elements from the temporary arrays back into the data array.
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

        //copy any remaining elements from the left portion.
        while (i < n1) {
            data[k] = (T) L[i];
            i++;
            k++;
        }

        //copy any remaining elements from the right portion.
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
            //if the index is 0 increment it to 1
            if (index == 0)
                index++;
            //if the index is greater than or equal to the previous element, increase the index.
            if (comparator.compare(data[index], data[index - 1]) < 0) {
                index++;
            }
            else {

                //If the current element is less than the previous element, swap them.
                T temp = data[index];
                data[index] = data[index - 1];
                data[index - 1] = temp;
                index--;
            }
        }
        return;
    }

}
