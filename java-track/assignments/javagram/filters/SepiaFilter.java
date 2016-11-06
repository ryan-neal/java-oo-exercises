package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class SepiaFilter implements Filter {
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
	          
	          int newRed = (int)(r * 0.393 + g * 0.769 + b * 0.189);
	          if (newRed > 255)
	          {
	        	  newRed = 255;
	          } 
              int newGreen = (int)(r * 0.349 + g * 0.686 + b* 0.168);
              if (newGreen > 255){
            	  newGreen = 255;
              }
              int newBlue = (int)(r * 0.272 + g * 0.534 + b * 0.131);
              if (newBlue > 255){
            	  newBlue = 255;
              }
	          
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}
}
