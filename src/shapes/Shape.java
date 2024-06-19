package shapes;

public abstract class Shape {
    private final double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public abstract double calcVolume();

    public abstract double calcBaseArea();

}


