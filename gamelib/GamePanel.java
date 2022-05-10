package gamelib;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

//DO NOT EDIT THIS CLASS
public class GamePanel extends JPanel implements Runnable {
    
    protected static int WIDTH = 900, HEIGHT = 600;
    protected static int FPS = 60;
    protected static Color BACKGROUND = new Color(10,10,10);

    Thread gameThread;

    public GamePanel(){
        this(WIDTH,HEIGHT,FPS,BACKGROUND);
    }

    public GamePanel(int width, int height, int fps, Color background){
        WIDTH = width; HEIGHT = height;
        FPS = fps;
        BACKGROUND = background;

        setPreferredSize(new Dimension(width, height));
        addKeyListener(new KeyInput());
        setFocusable(true);
        setBackground(background);
        
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void run(){
        //How this works
        //Calculate nanoseconds between frames by
        //dividing nanoseconds (1 billion) in 1 second by the FPS
        int drawInterval = 1000000000/FPS;
 
        long lastTime = System.nanoTime(); //The last time checked
        long currentTime; //The current time

        long delta = 0; //Nanoseconds since the last frame was drawn

        while (gameThread != null){

            currentTime = System.nanoTime(); //Get the current time in nanoseconds
            delta += currentTime - lastTime; //Add time difference to delta
            lastTime = currentTime;

            //If enough time has passed, draw the frame
            if (delta >= drawInterval){
                update();
                repaint();
                delta = 0;
            }
        }
    }

    /** Draw objects to the screen */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //Use graphics 2d because its better
        draw(g2);
        g2.dispose(); //Get rid of the graphics when we are done
    }

    public void keyPressed(String key){}
    public void keyReleased(String key){}
    public void update(){}
    public void draw(Graphics2D g){}

    class KeyInput implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            GamePanel.this.keyPressed(KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            GamePanel.this.keyReleased(KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}
