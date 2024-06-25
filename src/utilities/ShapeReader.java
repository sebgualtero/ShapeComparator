package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import shapes.*;

/**
 * A utility class that reads shape data from a file and returns an array of Shape objects.
 * @author sukhd
 */
public class ShapeReader {
    /**
     * Reads shape data from a file and returns an array of Shape objects.
     * @param filename the name of the file to read data from.
     * @return an array of Shape Objects, or null if an error occurs.
     */
    public static Shape[] readShapesFromFile(String filename) {
        Shape[] shapes = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            //Reads the first line, which contains the number of shapes.
            String line = br.readLine();
            if (line != null) {
                int numberOfShapes = Integer.parseInt(line);
                shapes = new Shape[numberOfShapes];

                //Reads each shape's data and create a Shape object.
                for (int i = 0; i < numberOfShapes; i++) {
                    line = br.readLine();
                    if (line != null) {
                        String[] parts = line.split(" ");
                        String shapeType = parts[0];
                        double height = Double.parseDouble(parts[1]);
                        double secondValue = Double.parseDouble(parts[2]);

                        //Creates a Shape object based on the shape type and values
                        Shape shape = createShape(shapeType, height, secondValue);
                        shapes[i] = shape;
                    }
                }
            }
        } catch (IOException e) {
            //Handles any IO exception that occurs while reading the file.
            e.printStackTrace();
        }

        return shapes;
    }

    /**
     * Creates a Shape object based on the shape type and values such as height and second value.
     * 
     * @param shapeType the type of shape such as Cone, Cylinder, OctagonalPrisn etc.
     * @param height the height of the shape
     * @param secondValue the second value of the shape such as radius, edge length etc
     * @return a Shape object, or thrown an exception if the type is unknown.
     */
    private static Shape createShape(String shapeType, double height, double secondValue) {
        switch (shapeType) {
            case "Cone":
                return new Cone(height, secondValue);
            case "Cylinder":
                return new Cylinder(height, secondValue);
            case "Pyramid":
                return new Pyramid(height, secondValue);
            case "SquarePrism":
                return new SquarePrism(height, secondValue);
            case "TriangularPrism":
                return new TriangularPrism(height, secondValue);
            case "PentagonalPrism":
                return new PentagonalPrism(height, secondValue);
            case "OctagonalPrism":
                return new OctagonalPrism(height, secondValue);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}
