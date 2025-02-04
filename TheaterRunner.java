import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {
    //2D Arrays
    //names of each of the characters in their own rows
    String[][] names = {
  {"Aladdin"},
  {"Mulan"},
  {"Pluto"},
  {"Daisy Duck"}
};
// how old the characters are now/how old their first movie is
String[][] ages = {
  {"33 years old"},
  {"27 years old"},
  {"85 years old"},
  {"85 years old"}
};
 // creates image filters that displays each image in rows and columns   
ImageFilter[][] images = {
  {new ImageFilter("aladdin.jpg"), new ImageFilter("mulan.jpg") },
  {new ImageFilter("pluto.jpg"), new ImageFilter("daisy.jpg") },
};
  
MyStory scene = new MyStory(names, ages, images);

    scene.drawScene();
  
    

    
        // Plays the scene
    Theater.playScenes(scene);
  }
}