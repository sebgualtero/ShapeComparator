package appDomain;

import shapes.*;
import utilities.ShapeReader;
import utilities.Sorter;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		String compareType = parseArguments(args)[0];
		String filename = parseArguments(args)[1];
		String algorithm = parseArguments(args)[2];

		long startTime = 0;
		long endTime = 0;

		String algoName = "";

		System.out.println(compareType);
		System.out.println(filename);
		System.out.println(algorithm);

		System.out.println("\n \nComparator \n\n");

		Shape [] shapes1 = ShapeReader.readShapesFromFile(filename);

		Sorter sorter = new Sorter<>(shapes1, compareType);
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
			case "c":{
				startTime = System.currentTimeMillis();
				sorter.countingSort();
				endTime = System.currentTimeMillis();
				algoName = "Counting Sort";
			} break;
		}

		System.out.println(shapes1[0].getClass().getSimpleName()+ "\tBase Area: " + shapes1[0].calcBaseArea() + "\tVolume: " + shapes1[0].calcVolume() + "\t Heigth: " + shapes1[0].getHeight());
		for (int j = 1000;  j < shapes1.length; j +=1000){
			System.out.println(shapes1[j].getClass().getSimpleName()+ "\tBase Area: " + shapes1[j].calcBaseArea() + "\tVolume: " + shapes1[j].calcVolume() + "\t Heigth: " + shapes1[j].getHeight());
		}
		System.out.println(shapes1[shapes1.length-1].getClass().getSimpleName()+ "\tBase Area: " + shapes1[shapes1.length-1].calcBaseArea() + "\tVolume: " + shapes1[shapes1.length-1].calcVolume() + "\t Heigth: " + shapes1[shapes1.length-1	].getHeight());

		//total time to run algorithm
		System.out.println("Time to run sorting using " + algoName +"= " + (endTime - startTime) + " Miliseconds");


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
