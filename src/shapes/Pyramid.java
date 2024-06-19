package shapes;

public class Pyramid extends Shape
{
    double side;

    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }
}
