package shapes;

/**
 * This class represents a Cylinder shape, which is a subclass of the Shape class.
 * @author sukhd
 */
public class Cylinder extends Shape
{
    double radius;
    /**
     * Constructor
     * @param height inherited from the abstract class called shape
     * @param radius the class given radius
     */
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    /**
     * Calculates the volume of the cylinder.
     * @return volume of cylinder
     */
    @Override
    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * getHeight();
    }

    /**
     * Calculates the area of the base of the cylinder
     * @return base area of cylinder
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
