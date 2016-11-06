package javagram;
import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Javagram {


	public static void main(String[] args) throws Exception {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		String imagePath = "Path not set";
		
		// prompt user for image to filter and validate input
		do {
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				
				
				//imagePath = (dir + "\\" + relPath);
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		Filter filter = null;
		// TODO - prompt user for filter and validate input
		do {
			// TODO Auto-generated method stub
			System.out.println("Please enter an intenger\n"
					+ "1: Blue\n"
					+ "2: Greyscale\n"
					+ "3: Inverted\n"
					+ "4: Black and White\n"
					+ "5: Brightness\n"
					+ "6: Flip Horizontally\n"
					+ "7: Flip Vertically\n"
					+ "8: Sepia");
			int number = in.nextInt();
			try {
				filter = getFilter(number);	
			}
			catch (InputMismatchException ex){
				System.out.println("Not a valid number");
			}}
			while (filter == null);
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 		
		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		String fileName = "";
		String absFileName;
		
		do {
			
			// prompt for save destination
			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving): ");
			fileName = in.next();
			absFileName = dir + File.separator + fileName;
			
			// confirm overwriting of original file
			if (absFileName.equals(imagePath)) {
				System.out.println("Are you sure you want to overwrite the original file? (yes or no): ");
				String verify = in.next();
				
				// user does not confirm overwriting
				if (!verify.equals("yes")) {
					fileName = "";
				}
				
			}
			
		} while (fileName.equals(""));
		
		// save file, or exit, as specified by user
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}


	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int number) throws InputMismatchException {
		switch(number){
		case 1: return new BlueFilter();
		case 2: return new GreyFilter();
		case 3: return new InvertFilter();
		case 4: return new BlackAndWhiteFilter();
		case 5: return new BrightFilter();
		case 6: return new UpsideFilter();
		case 7: return new VerticalFilter();
		case 8: return new SepiaFilter();
		default: throw new InputMismatchException("Please enter a number");
	}
	}
}

