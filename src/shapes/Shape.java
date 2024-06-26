package shapes;

/**
 * This is an abstract class that represents a Shape.
 * @author sukhd
 */
public abstract class Shape {
    private final double height;

    /**
     * Constructor
     * @param height the height of the shape 
     */
    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Abstract method to calculate the volume of the shape.
     * @return the volume of the shape
     */
    public abstract double calcVolume();

    /**
     * Abstract method to calculate the area of the shape's base.
     * @return the area of the shape's base.
     */
    public abstract double calcBaseArea();

    /**
     * Method to get a property value of the shape based on the compare type.
     * @param compareType The type of property to get such as "a" for area, "v" for volume, or any other string for height.
     * @return the property value of the shape
     */
    public double getPropertyValue(String compareType) {
        if (compareType.equals("a")) return calcBaseArea();
        else if (compareType.equals("v")) return calcVolume();
        else return getHeight();
    }
}


