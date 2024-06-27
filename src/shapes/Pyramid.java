package shapes;

/**
 * This class represents a Pyramid shape, which is a subclass of the Shape class.
 * @author sukhd
 */
public class Pyramid extends Shape
{
    double side;

    /**
     * Constructor
     * @param height the height of the pyramid
     * @param side the side length of the pyramid's base.
     */
    public Pyramid(double height, double side) {
        //inherited height from the Shape class
        super(height);
        this.side = side;
    }

    /**
     * Calculate the volume of the pyramid
     * @return the volume of the pyramid
     */
    @Override
    public double calcVolume() {
        return (1.0 / 3) * calcBaseArea() * getHeight();
    }

    /**
     * Calculates the area of the pyramid's base
     * @return the pyramid's base area.
     */
    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }
}
