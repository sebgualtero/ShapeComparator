package utilities;

import shapes.Shape;

public class Sorter<T extends Shape> {
    private T[] data;

    String compareType; //this is going to be used by the comparator
    ShapeComp comparator = null;

    public Sorter(T[] data, String compareType){
        this.data = data;
        this.compareType = compareType;

        switch(compareType){
            case "a": comparator = new AreaComparator(); break;
            case "v": comparator = new VolumeComparator(); break;
            case "h": comparator = new HeightComparator(); break;
            default: comparator = new HeightComparator(); break;
        }
    }

    public T[] getData() {
        return data;
    }

    public void selectionSort() {

        for (int i = 0; i < data.length ; i++) {
            T min = this.data[i];
            int minIndex = i;

            for (int j = i + 1; j < data.length; j++) {
                if (comparator.compare(min, data[j]) < 0) {
                    min = data[j];
                    minIndex = j;
                }
            }
//            System.out.println("new loop");
//            System.out.println(i);
//            System.out.println(minIndex);

            swap(i,minIndex);
        }


    }

    public void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

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

    public void countingSort() {
        int n = data.length;

        // Determine the range of the data
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (T shape : data) {
            double value = shape.getPropertyValue(compareType);
            if (value > max) max = value;
            if (value < min) min = value;
        }

        // Scaling factor to preserve decimal places
        int scaleFactor = 100000000;

        // Adjust values to be positive integers within the appropriate range
        int adjustedMin = (int) (min * scaleFactor);
        int adjustedMax = (int) (max * scaleFactor);
        int range = adjustedMax - adjustedMin + 1;

        // Create a count array with the range
        int[] countArray = new int[range];

        // Initialize count array
        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int index = (int) (data[i].getPropertyValue(compareType) * scaleFactor) - adjustedMin;
            countArray[index]++;
        }

        // Change count[i] so that count[i] now contains actual position of this value in output[]
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the output array
        T[] output = (T[]) new Shape[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = (int) (data[i].getPropertyValue(compareType) * scaleFactor) - adjustedMin;
            output[countArray[index] - 1] = data[i];
            countArray[index]--;
        }

        // Copy the output array to data[], so that data[] now contains sorted numbers
        for (int i = 0; i < n; i++) {
            data[i] = output[i];
        }
    }

}
