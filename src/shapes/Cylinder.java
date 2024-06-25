package shapes;

public class Cylinder extends Shape
{
    double radius;
    /**
     * 
     * @param height inherited from the abstract class called shape
     * @param radius the class given radius
     */
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
