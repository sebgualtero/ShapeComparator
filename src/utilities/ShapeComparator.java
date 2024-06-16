package utilities;

import shapes.Shape;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {

    private String compareType;

    public ShapeComparator(String compareType) {
        this.compareType = compareType;
    }

    @Override
    public int compare(Shape s1, Shape s2) {
        switch (compareType) {
            case "h":
                return Double.compare(s1.getHeight(), s2.getHeight());
            case "v":
                return Double.compare(s1.calcVolume(), s2.calcVolume());
            case "a":
                return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
            default:
                throw new IllegalArgumentException("Invalid compare type: " + compareType);
        }
    }
}
