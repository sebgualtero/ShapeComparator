package utilities;

import shapes.Shape;

import java.util.Comparator;

/**
 *An interface that extends the comparator interface, mainly to compare shape objects.
 * Any class that will implement this interface would have to implement compare method.
 * @author sukhd
 */
public interface ShapeComp extends Comparator<Shape> {
    //This interface inherits the compare method from comparator, which is used here to compare two shape objects.
    //This compare method is not implemented here but rather the children classes that implements this interface
}


