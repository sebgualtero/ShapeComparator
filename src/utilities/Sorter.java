package utilities;

import shapes.Shape;

public class Sorter<T extends Shape> {
    private T[] data;

    String compareType; //this is going to be used by the comparator
    ShapeComp comparator = null;

    public Sorter(T[] data, String compareType){
        this.data = data;
        if (compareType.equals("a"))
            comparator = new AreaComparator();
        else if (compareType.equals("v"))
            comparator = new VolumeComparator();
        else if (compareType.equals("h"))
            comparator = new HeightComparator();
        else
            comparator = null;
    }

    public T[] getData() {
        return data;
    }

    public void selectionSort() {

        for (int i = 0; i < data.length ; i++) {
            T min = this.data[i];
            int minIndex = i;

            for (int j = i + 1; j < data.length; j++) {
                if (comparator.compare(min, data[j]) > 0) {
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
}
