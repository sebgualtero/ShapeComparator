package shapes;

/**
 * This class represents a Cone shape which is a subclass of the Shape class.
 * @author sukhd
 */
public class Cone extends Shape {
    double radius;
    /**
     * Constructor
     * @param height inherited from the abstract class called shape.
     * @param radius cone's given radius.
     */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    /**
     * Calculate the volume of the cone
     * @return  the volume of the cone.
     */
    @Override
    public double calcVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * getHeight();
    }

    /**
     * Calculates the area of the base of the cone.
     * @return the base area.
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
