import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {
  
// Instance Variables
  private String[][] name;
  private String[][] ages;
  private ImageFilter[][] img;
// Constructor
  public MyStory(String[][] name, String[][] ages, ImageFilter[][] img) {
    this.name = name;
    this.ages = ages;
    this.img = img;
  }
//Main drawScene method that displays the name scene then the image scene, then all the characters
  public void drawScene() {
    playSound("disney_audio.wav");
    drawNameScene();
    drawAgesScene();
    drawImageScene();
    drawCharacterImage("aladdin.jpg", 20, 40);
    drawCharacterImage("mulan.jpg", 200, 40);
    drawCharacterImage("pluto.jpg", 20, 250);
    drawCharacterImage("daisy.jpg", 200, 250);  
  }
  //displays each of the character's names in where the 
  //image of them will be displayed
  public void drawNameScene() {
    clear("indigo");
      setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.NORMAL);
     drawText(name[0][0], 50, 100);
    pause(0.5);
    drawText(name[1][0], 250, 100);
    pause(0.5);
    drawText(name[2][0], 50, 300);
    pause(0.5);
    drawText(name[3][0], 250, 300);

    pause(1.0);
  }
  /*
  *this sets the screen to indigo and displays all
  *their respective ages of how old their film is
  */ 
  public void drawAgesScene() {
    clear("indigo");
      setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.NORMAL);
     drawText(ages[0][0], 50, 100);
    pause(0.5);
    drawText(ages[1][0], 250, 100);
    pause(0.5);
    drawText(ages[2][0], 50, 300);
    pause(0.5);
    drawText(ages[3][0], 250, 300);

    pause(1.0);
  }
// draws the title and makes it a certain font
  public void drawImageScene(){
    clear("indigo");
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD_ITALIC);
    drawText("Disney Characters", 80, 20);
  }
  /*
  *creates if statments that depending on what image is inputted on the drawCharacterImage, 
  *it will display that image and where it will go depending on the coordinates put
  */
  public void drawCharacterImage(String imageName, int x, int y){
      ImageFilter character = new ImageFilter(imageName);
    // this is a placeholder statement to return if there is no character input 
    if (character != null) {
      drawImage(character, x, y, 150);
      pause(0.5);
      // will display aladdin and the filters
      if (imageName.equals("aladdin.jpg")) {
        character.keepColor("white");
        character.colorShift(100);
      // will display mulan and the filters
      } else if (imageName.equals("mulan.jpg")) {
        character.keepColor("blue");
        character.saturate(1);
      // will display pluto and the filters
      } else if (imageName.equals("pluto.jpg")) {
        character.keepColor("white");
        character.motionBlur(10, "diagonal");
      // will display daisy and the filters
      } else if (imageName.equals("daisy.jpg")) {
        character.keepColor("white");
        character.vintage(100);
      }
      // will print this out in the console log if nothing could be loaded
      drawImage(character, x, y, 150);
    } else {
      System.out.println("Image " + imageName + " could not be loaded.");
  }
    }
}