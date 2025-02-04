import org.code.theater.*;
import org.code.media.*;

/*
* Represents a image that contains multiple filters
*/
public class ImageFilter extends Image {
  private Pixel[][] pixels;
  /*
  * Calls the superclass constructor to intialize the 2D Array
  */
  public ImageFilter(String filename) {
    super(filename);   // Calls the Image class constructor
    pixels = getPixelsFromImage();
  }

  public Pixel[][] getImagePixels() {
    return pixels;
  }

  
    /*
   * Returns the pixels in the image as a 2D array of Pixel objects
   */
  public Pixel[][] getPixelsFromImage() {
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];
    
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        tempPixels[row][col] = getPixel(col, row);
      }
    }

    return tempPixels;
  }
  
    /** IMAGE FILTERS FROM LESSON 8 */
  // saturates the image and turns it more black
     public void saturate(int factor) {
       Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
            int red = currentPixel.getRed();
            int green = currentPixel.getGreen();
            int blue = currentPixel.getBlue();
           int average = (red + green + blue) / 3;

           
            int adjustedGrayscale = average + (average - 255) * factor;
            // calculated the rgb values based on the greyscale
            int newRed = (int)(2 * adjustedGrayscale - red);
            int newGreen = (int)(2 * adjustedGrayscale - green);
            int newBlue = (int)(2 * adjustedGrayscale - blue);

            //makes sure that the rgb values are in range
            newRed = Math.min(newRed, 255);
            newGreen = Math.min(newGreen, 255);
            newBlue = Math.min(newBlue, 255);

           //sets the rgb values to the current pixel
            currentPixel.setRed(newRed);
            currentPixel.setGreen(newGreen);
            currentPixel.setBlue(newBlue);
      }
    }
  }
// blurs the image in the direction you want and how much you want
   public void motionBlur(int length, String direction) {
      Pixel[][] pixels = getPixelsFromImage();
          for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < pixels[0].length; col++) {
            Pixel currentPixel = pixels[row][col];
            int totalRed = 0, totalGreen = 0, totalBlue = 0;
            int count = 0;

            // Traverse neighboring pixels based on the specified direction
            for (int i = 0; i < length; i++) {
                int newRow = row;
                int newCol = col;

                // Determine new pixel position based on direction
                if (direction.equals("horizontal")) {
                    newCol += i;
                } else if (direction.equals("vertical")) {
                    newRow += i;
                } else if (direction.equals("diagonal")) {
                    newRow += i;
                    newCol += i;
                }

                // Check if the new position is within bounds
                if (newRow < pixels.length && newCol < pixels[0].length) {
                    Pixel neighborPixel = pixels[newRow][newCol];
                    totalRed += neighborPixel.getRed();
                    totalGreen += neighborPixel.getGreen();
                    totalBlue += neighborPixel.getBlue();
                    count++;
                }
            }

            // Calculate average color values
            if (count > 0) {
                currentPixel.setRed(totalRed / count);
                currentPixel.setGreen(totalGreen / count);
                currentPixel.setBlue(totalBlue / count);
            }
        }
    }
   }
  //shifts the color to the desired color value chosen
   public void colorShift(int value) {
     Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        int newRed = currentPixel.getRed() + value;
        // creates if statements to ensure that the rgb values don't exceed 255 (max)
        if(newRed > 255){
          newRed = 255;
        }
        currentPixel.setRed(newRed); //sets it to the new red value
         int newBlue = currentPixel.getBlue() + value;
         if(newBlue > 255){
          newBlue = 255;
        }
        currentPixel.setBlue(newBlue); //sets it to the new blue value
        int newGreen = currentPixel.getGreen() + value;
         if(newGreen > 255){
          newGreen = 255;
         }
        currentPixel.setGreen(newGreen);//sets it to the new green value
      
      }
    }
  }
//keps the color to only one and removes/dims the others
  public void keepColor(String color){
  Pixel[][] pixels = getImagePixels();
  for(int row = 0; row< pixels.length; row++){
      for(int col = 0; col< pixels[0].length; col++){
        Pixel currentPixel = pixels[row][col];
       if(color.equals("red")){
         currentPixel.setGreen(0); // removes green component
         currentPixel.setBlue(0); // removes blue component
       } else if(color.equals("blue")){
          currentPixel.setGreen(0); // removes green component
         currentPixel.setRed(0); // removes red component
       } else if(color.equals("green")){
          currentPixel.setRed(0); // removes red component
         currentPixel.setBlue(0);// removes blue component
       }
    }
  }
}
  //my own filter creation - vintage filter
  public void vintage(int value){
  Pixel[][] pixels = getImagePixels();
   for(int row = 0; row< pixels.length; row++){
      for(int col = 0; col< pixels[0].length; col++){
        Pixel currentPixel = pixels[row][col];
          int red = currentPixel.getRed();
            int green = currentPixel.getGreen();
            int blue = currentPixel.getBlue();

            // Applies vintage effect by modifying RGB values
            red = Math.min(255, red + value); // Increase red
            green = Math.max(0, green - value / 2); // Decrease green
            blue = Math.max(0, blue - value / 2); // Decrease blue

            currentPixel.setRed(red);
            currentPixel.setGreen(green);
            currentPixel.setBlue(blue);
  }
   }
  }
  }
