package appDomain;

import shapes.*;
import utilities.ShapeComparator;
import utilities.ShapeReader;

import java.util.Arrays;
import java.util.Scanner;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		//check and document

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String

		//creates a scanner to get an user input for the compareType variable
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter compare type (h for height, v for volume, a for base area): ");
		String compareType = scanner.nextLine();


//		Shape cone = new Cone(10, 5);
//		Shape cylinder = new Cylinder(10, 5);
//		Shape pyramid = new Pyramid(10, 5);
//		Shape squarePrism = new SquarePrism(10, 5);
//		Shape triangularPrism = new TriangularPrism(10, 5);
//		Shape pentagonalPrism = new PentagonalPrism(10, 5);
//		Shape octagonalPrism = new OctagonalPrism(10, 5);
//
//		System.out.println("Cone Volume: " + cone.calcVolume());
//		System.out.println("Cylinder Volume: " + cylinder.calcVolume());
//		System.out.println("Pyramid Volume: " + pyramid.calcVolume());
//		System.out.println("Square Prism Volume: " + squarePrism.calcVolume());
//		System.out.println("Triangular Prism Volume: " + triangularPrism.calcVolume());
//		System.out.println("Pentagonal Prism Volume: " + pentagonalPrism.calcVolume());
//		System.out.println("Octagonal Prism Volume: " + octagonalPrism.calcVolume());

		System.out.println("\n \nComparator \n\n");
		System.out.println("\n \nJeff Code here \n\n");

		Shape[] shapes = {
				new Cone(10, 5),
				new Cylinder(10, 5),
				new Pyramid(10, 5),
				new SquarePrism(10, 5),
				new TriangularPrism(10, 5),
				new PentagonalPrism(10, 5),
				new OctagonalPrism(10, 5)
		};

		ShapeComparator shapeComparator = new ShapeComparator(compareType);

		Arrays.sort(shapes, shapeComparator);

//		for (Shape shape : shapes) {
//			System.out.println(shape.getClass().getSimpleName() + " Base Area: " + shape.calcBaseArea() + " Volume: " + shape.calcVolume());
//		}

		ShapeReader SR = new ShapeReader();

		Shape [] shapes1 = ShapeReader.readShapesFromFile("res/shapes2.txt");

		Arrays.sort(shapes1, shapeComparator);

		for (Shape shape : shapes1) {
			System.out.println(shape.getClass().getSimpleName() + " Base Area: " + shape.calcBaseArea() + " Volume: " + shape.calcVolume());
		}
	}

}
