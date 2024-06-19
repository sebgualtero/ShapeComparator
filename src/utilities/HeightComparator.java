package utilities;

import shapes.Shape;

public class HeightComparator implements ShapeComp{
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.getHeight() < o2.getHeight())
            return -1;
        else if (o1.getHeight()> o2.getHeight())
            return 1;
        else
            return 0;

    }
}
