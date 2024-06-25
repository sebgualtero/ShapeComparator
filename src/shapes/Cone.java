package shapes;


public class Cone extends Shape {
    double radius;
    /**
     * 
     * @param height inherited from the abstract class called shape.
     * @param radius cone's given radius.
     */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
