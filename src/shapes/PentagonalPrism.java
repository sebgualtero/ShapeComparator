package shapes;

public class PentagonalPrism extends Prism
{
    public PentagonalPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    @Override
    public double calcBaseArea() {
        return (5.0 / 4) * Math.pow(side, 2) * (1.0 / Math.tan(Math.PI / 5));
    }
}
