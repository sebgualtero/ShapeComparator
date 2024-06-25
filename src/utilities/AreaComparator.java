package utilities;

import shapes.Shape;

/**
 * A comparator class that compares two Shape objects based on their base area.
 * @author sukhd
 */
public class AreaComparator implements ShapeComp {

    /**
     * Compares two Shape Objects based on their base area.
     * 
     * @param o1 the first Shape object.
     * @param o2 the second Shape object.
     * @return -1 if o1 has a smaller base area, 1 if the o2 has a smaller base area or zero if they're equal.
     */
    @Override
    public int compare(Shape o1, Shape o2) {
        //Compares the base area of the two objects.
        if(o1.calcBaseArea() < o2.calcBaseArea())
            return -1;//01 has a smaller base area, return -1.
        else if (o1.calcBaseArea()> o2.calcBaseArea())
            //02 has a smaller base area, return 1.
            return 1;
        else
            // The base areas are equal, return 0.
            return 0;

    }

}
