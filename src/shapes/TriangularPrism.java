package shapes;
/**
 * This class represents a triangular prism shape which is a subclass of the Prism class.
 * @author sukhd
 */
public class TriangularPrism extends Prism
{
    /**
     * Constructor
     * @param height the height of the triangular prism.
     * @param side the side length of the triangular prism.
     */
    public TriangularPrism(double height, double side) {
        super(height, side);
    }

    /**
     * Calculates the volume of of he triangular prism.
     * @return the volume of the triangular prism.
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    /**
     * Calculates the area of the triangular prism's base.
     * @return the base area of triangular prism.
     */
    @Override
    public double calcBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }
}
