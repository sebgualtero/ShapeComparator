package shapes;

public abstract class Prism extends Shape {
    double side;

    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }

}
