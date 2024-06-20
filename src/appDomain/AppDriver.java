package appDomain;

import shapes.*;
import utilities.ShapeReader;
import utilities.Sorter;

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


		String compareType = parseArguments(args)[0];
		String filename = parseArguments(args)[1];
		String algorithm = parseArguments(args)[2];

		System.out.println(compareType);
		System.out.println(filename);
		System.out.println(algorithm);

		System.out.println("\n \nComparator \n\n");

		Shape [] shapes1 = ShapeReader.readShapesFromFile(filename);

		Sorter sorter = new Sorter<>(shapes1, compareType);

		sorter.countingSort();

		for (Shape shape : sorter.getData()) {
			System.out.println(shape.getClass().getSimpleName() + "\tBase Area: " + shape.calcBaseArea() + "\tVolume: " + shape.calcVolume() + "\t Heigth: " + shape.getHeight());

		}
	}

	private static String[] parseArguments(String[] args) {

        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: java Main -t[h|v|a] -f[filename] -s[type of sorting algorithm]");
        }

        String compareType = null;
		String filename = null;
		String algorithm = null;

        for (int i = 0; i < args.length; i++) {
			args[i] = args[i].toLowerCase();
            if (args[i].startsWith("-t")) {
                compareType = args[i].substring(2);
            } else if (args[i].startsWith("-f")) {
                filename = args[i].substring(2);
            } else if (args[i].startsWith("-s")) {
                algorithm = args[i].substring(2);
            } else {
                throw new IllegalArgumentException("Invalid argument: " + args[i]);
            }

        }
        return new String[]{compareType, filename, algorithm};
    }

}
