package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Javagram {
	private static Scanner in;

	public static int startMenu(){
		System.out.println("Please enter an intenger/n"
			+ "1: Blue/n"
			+ "2: Greyscale/n"
			+ "3: Monchromatic/n"
			+ "4: Black and White/n"
			+ "5: Inverted/n"
			+ "6: Brightness"
			+ "7: Exit");
		int selection = in.nextInt();
		while (selection < 0 || selection > 7){
			System.out.println("Invalid selection. Please enter another integer: ");
			selection = in.nextInt();
		}
		return selection;
	}

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				/*
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				
				imagePath = (dir + "\\" + relPath);
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		int number = startMenu();
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = getFilter(number);			
		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int number) {
		
		// TODO - create some more filters, and add logic to return the appropriate one
		if (number == 1) {
			return new BlueFilter();
		}
		else{
			return null;
		}
	}

}