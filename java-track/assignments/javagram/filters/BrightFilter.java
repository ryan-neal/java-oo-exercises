package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BrightFilter implements Filter{
	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newRed = 0;
	          int newGreen= 0;
	          int newBlue = 0;
	          
	          if (r < 204){
	        	  newRed = r + 50;
	          }
	          else{
	        	  newRed = 255;
	          }
	          
	          if (g< 204){
	        	  newGreen = g + 50;
	          }
	          else{
	        	  newGreen = 255;
	          }
	          
	          if (b < 204){
	        	  newBlue = b + 50;
	          }
	          else{
	        	  newBlue = 255;
	          }
	          
	          
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}
}
