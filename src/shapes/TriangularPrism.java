package shapes;

public class TriangularPrism extends Prism
{
    public TriangularPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }
}
