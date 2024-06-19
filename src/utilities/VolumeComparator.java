package utilities;

import shapes.Shape;

import java.util.Comparator;

public class VolumeComparator implements ShapeComp {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.calcVolume() < o2.calcVolume())
            return -1;
        else if (o1.calcVolume() > o2.calcVolume())
            return 1;
        else
            return 0;
    }
}
