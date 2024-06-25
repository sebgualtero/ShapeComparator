package utilities;

import shapes.Shape;

/**
 * A Comparator class that compares two Shape Objects based on their heights.
 * @author sukhd
 */
public class HeightComparator implements ShapeComp{ 
    
    /**
     * Compares two objects based on their heights.
     * 
     * @param o1 The first Shape object.
     * @param o2 The second Shape objects.
     * @return -1 if 01 is shorter , 1 if 02 is shorter, or 0 if they are the same height.
     */
    @Override
    public int compare(Shape o1, Shape o2) {
        // Compares the heights of the two shapes
        if(o1.getHeight() < o2.getHeight())
            //01 is shorter, return 01
            return -1;
        else if (o1.getHeight()> o2.getHeight())
            //02 is shorder, retrun 1
            return 1;
        else
            //The heights are equal, retru 0
            return 0;

    }
}
