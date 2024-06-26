package appDomain;

import shapes.*;
import utilities.ShapeReader;
import utilities.Sorter;
/**
 * The main application driver class.
 * @author sukhd
 */
public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
                /**
                 * parse command-line arguements
                 */
		String compareType = parseArguments(args)[0];
		String filename = parseArguments(args)[1];
		String algorithm = parseArguments(args)[2];

		long startTime = 0;
		long endTime = 0;

		String algoName = "";

		System.out.println(compareType);
		System.out.println(filename);
		System.out.println(algorithm);

		System.out.println("\n \nSorter \n\n");

                //reads shapes from file
		Shape [] shapes1 = ShapeReader.readShapesFromFile(filename);
                
                //creates a sorter instance
		Sorter sorter = new Sorter<>(shapes1, compareType);
		
                //Performs sorting based on the chosenn algorithm
                switch (algorithm){
			case "b": {
				startTime = System.currentTimeMillis();
				sorter.bubbleSort();
				endTime = System.currentTimeMillis();
				algoName = "Bubble Sort";
			} break;
			case "i": {
				startTime = System.currentTimeMillis();
				sorter.insertionSort();
				endTime = System.currentTimeMillis();
				algoName = "Insertion Sort";
			} break;
			case "s": {
				startTime = System.currentTimeMillis();
				sorter.selectionSort();
				endTime = System.currentTimeMillis();
				algoName = "Selection Sort";
			} break;
			case "m": {
				startTime = System.currentTimeMillis();
				sorter.mergeSort();
				endTime = System.currentTimeMillis();
				algoName = "Merge Sort";
			} break;
			case "q": {
				startTime = System.currentTimeMillis();
				sorter.quickSort();
				endTime = System.currentTimeMillis();
				algoName = "Quick Sort";
			} break;
			case "z":{
				startTime = System.currentTimeMillis();
				sorter.gnomeSort();
				endTime = System.currentTimeMillis();
				algoName = "Gnome Sort";
			} break;
			default:{
				throw new IllegalArgumentException("Chosen algorithm " + algorithm + " not available, please use [b], [s], [m], [q], [c] or [z]");
			}
		}
                /**
                 * @author - Jeffry
                 * Prints out the first sorted output then prints out the 1000th sorted item from the list of items collected
                 * length-1 means since we started with 1, the next print out is 1001, the -1 makes sure that the 1000th line is printed out
                 */
		System.out.println(shapes1[0].getClass().getSimpleName()+ "\tBase Area: " + shapes1[0].calcBaseArea() + "\tVolume: " + shapes1[0].calcVolume() + "\t Heigth: " + shapes1[0].getHeight());
		for (int j = 1000;  j < shapes1.length; j +=1000){
			System.out.println(shapes1[j].getClass().getSimpleName()+ "\tBase Area: " + shapes1[j].calcBaseArea() + "\tVolume: " + shapes1[j].calcVolume() + "\t Heigth: " + shapes1[j].getHeight());
		}
		System.out.println(shapes1[shapes1.length-1].getClass().getSimpleName()+ "\tBase Area: " + shapes1[shapes1.length-1].calcBaseArea() + "\tVolume: " + shapes1[shapes1.length-1].calcVolume() + "\t Heigth: " + shapes1[shapes1.length-1	].getHeight());

		//total time to run algorithm
		System.out.println("\n \nTime to run " + algoName + " = " + (endTime - startTime) + " Miliseconds");
		System.out.println("Items sorted: " + shapes1.length);

	}
        
        /**
         * Parses the command-line arguments.
         * @param args the command-line arguments
         * @return an array of parsed arguments
         */
	private static String[] parseArguments(String[] args) {

        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: java Main -t[h|v|a] -f[filename] -s[type of sorting algorithm]");
        }
        
        /**
         * @author - Jeffry
         * initializes compareType, filename and algorithm to null so it is ready for processing
         * args[i] = args[i].toLowerCase(); - converts the input to lowercase once entered / added to the custom config run
         * uses the prefixes to determine what type of sorting algorithm to be used and which file to process 
         * depending on the entered sets of string in command prompt
         */
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
                throw new IllegalArgumentException("Invalid argument: " + args[i] +
						"\nUsage: java Main -t[h|v|a] -f[filename] -s[type of sorting algorithm]");
            }

        }
        return new String[]{compareType, filename, algorithm};
    }

}
