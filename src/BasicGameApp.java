
import java.awt.event.KeyEvent;
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
    public Surfer tom;
    public Image tomPic;

    public boolean tomAndJr = false;

    public Image backgroundpic;
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

            char key = e.getKeyChar();
            int keyCode = e.getKeyCode();
            System.out.println("Key pressed: " + key + ", key code: " + keyCode);
            if(keyCode == 38) {
                //tom.dy = -3;
                tom.upIsPressed = true;
            }// up
            if(keyCode == 40) {
                //tom.dy = 3;
                tom.downIsPressed = true;
            }//down
            if(keyCode == 39) {
                //tom.dx = +3;
                tom.rightIsPressed = true;
            }//right
            if(keyCode == 37) {
                // tom.dx = -3;
                tom.leftIsPressed = true;
            }//left

        }



    @Override
    public void keyReleased(KeyEvent e) {

            char key = e.getKeyChar();
            int keyCode = e.getKeyCode();
            System.out.println("Key pressed: " + key + ", key code: " + keyCode);
            if(keyCode == 38) {
                // tom.dy = 0;
                tom.upIsPressed = false;
            }// up
            if(keyCode == 40) {
                //tom.dy = 0;
                tom.downIsPressed = false;
            }//down
            if(keyCode == 39) {
                // tom.dx = 0;
                tom.rightIsPressed = false;
            }//right
            if(keyCode == 37) {
                // tom.dx = 0;
                tom.leftIsPressed = false;
            }//left

        }



    public BasicGameApp() {

        setUpGraphics();

        tom = new Surfer();
        tomPic = Toolkit.getDefaultToolkit().getImage("Surfer.png");


        backgroundpic = Toolkit.getDefaultToolkit().getImage("rail.jpeg");

    }

    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            collisions();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    public void moveThings() {
        //call the move() code for each object
        tom.move();
    }

    private void render() {

        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(backgroundpic, 0, 0, WIDTH, HEIGHT, null);
        //here
        g.drawImage(tomPic, tom.xpos, tom.ypos, tom.width, tom.height, null);

        g.dispose();
        bufferStrategy.show();
    }

    public void collisions() {
    }
        public void pause( int time ) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {

        }
    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }
}