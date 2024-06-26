package shapes;
/**
 * This is an abstract class that represents a Prism shape, which is a subclass of the Shape class.
 * @author sukhd
 */
public abstract class Prism extends Shape {
    double side;

    /**
     * Constructor
     * @param height the height of the prism.
     * @param side the side length of the prism's base.
     */
    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }

}
