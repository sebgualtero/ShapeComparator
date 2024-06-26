package shapes;
/**
 * This class represents a Square Prism which is a subclass of Shape
 * @author sukhd
 */
public class SquarePrism extends Shape
{
    double side;

    /**
     * Constructor
     * @param height the height of the square prism
     * @param side the side length of the square base.
     */
    public SquarePrism(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     * Calculates the volume of the square prism
     * @return the volume of the square prism
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    /**
     * Calculates the base area of the square prism
     * @return the area of the square prism's base.
     */
    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }
}
