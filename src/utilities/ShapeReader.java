package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import shapes.*;


public class ShapeReader {

    public static Shape[] readShapesFromFile(String filename) {
        Shape[] shapes = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line != null) {
                int numberOfShapes = Integer.parseInt(line);
                shapes = new Shape[numberOfShapes];

                for (int i = 0; i < numberOfShapes; i++) {
                    line = br.readLine();
                    if (line != null) {
                        String[] parts = line.split(" ");
                        String shapeType = parts[0];
                        double height = Double.parseDouble(parts[1]);
                        double secondValue = Double.parseDouble(parts[2]);

                        Shape shape = createShape(shapeType, height, secondValue);
                        shapes[i] = shape;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return shapes;
    }

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
