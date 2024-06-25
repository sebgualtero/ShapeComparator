package utilities;

import shapes.Shape;

import java.util.Comparator;

/**
 * A comparator class that compares two Shape objects based on their volume..
 * 
 * @author sukhd
 */
public class VolumeComparator implements ShapeComp {
    
    /**
     * Compares two Shape Objects based on their volume.
     * 
     * @param o1 the first Shape object.
     * @param o2 the second Shape object.
     * @return -1 if o1 has a smaller volume, 1 if the o2 has a smaller volume or zero if they're equal.
     */
    @Override
    public int compare(Shape o1, Shape o2) {
        //compares the values of the two shapes.
        if (o1.calcVolume() < o2.calcVolume())
            //o1 has a smaller volume, retrun 01.
            return -1;
        else if (o1.calcVolume() > o2.calcVolume())
            //02 has a smaller volume, return 1..
            return 1;
        else
            //the volumes are equal, return 0.
            return 0;
    }
}
