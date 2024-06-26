package shapes;
/**
 * This class represents a pentagonal prism shape which is a subclass of the Prism class.
 * @author sukhd
 */
public class PentagonalPrism extends Prism
{
    /**
     * Constructor
     * @param height the height of the pentagonal prism
     * @param side the side length of the pentagonal base
     */
    public PentagonalPrism(double height, double side) {
        super(height, side);
    }

    /**
     * Calculates the volume of the pentagonal prism.
     * @return the volume of the pentagonal prism
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    /**
     * Calculates the area of the pentagonal base.
     * @return the area of the pentagonal base.
     */
    @Override
    public double calcBaseArea() {
        return (5.0 / 4) * Math.pow(side, 2) * (1.0 / Math.tan(Math.PI / 5));
    }
}
