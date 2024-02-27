
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//*******************************************************************************

//step 1 for keyboard : , keyListener
public class BasicGameApp implements Runnable, KeyListener {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    // Object-Related variables
    // **** Step 1 : Declare Astronaut and its image
    public Surfer oliver;
    public Image oliverPic;
    public Surfer Jr;
    public Image JrPic;

    public boolean oliverAndJr = false;

    public Image backgroundpic;


    public class Main() {


        oliver = new Surfer( "Oliver", 200, 300);
        oliverPic = Toolkit.getDefaultToolkit().getImage("Astronaut.png");
        Jr = new Surfer( "Jr", 300, 200);
        JrPic = Toolkit.getDefaultToolkit().getImage("astroworld.png");

        backgroundpic = Toolkit.getDefaultToolkit().getImage("space.jpeg");

    }


}
