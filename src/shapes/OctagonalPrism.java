package shapes;
/**
 * This class represents an OctangonalPrism shape, which is a subclass of the Prism class.
 * @author sukhd
 */
public class OctagonalPrism extends Prism
{
    /**
     * Constructor
     * @param height the height of the octagonal prism
     * @param side the side length of the octagonal prism
     */
    public OctagonalPrism(double height, double side) {
        super(height, side);
    }
    
    /**
     * Calculates the volume of the octagonal prism.
     * @return the volume of octagonal prism
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    /**
     * Calculates the area of the base of the octagonal prism
     * @return The base area of the octagonal prism
     */
    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }
}
