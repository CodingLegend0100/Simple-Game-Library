package gamelib;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

//DO NOT EDIT THIS CLASS
public class GamePanel extends JPanel implements Runnable {
    
    protected int WIDTH = 900, HEIGHT = 600;
    protected int FPS = 60;

    Thread gameThread;

    public GamePanel(){
        this(900,600);
    }

    public GamePanel(int width, int height){
        WIDTH = width; HEIGHT = height;

        setPreferredSize(new Dimension(width, height));
        addKeyListener(new KeyInput());
        setFocusable(true);

    }

    public void start(){
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
    public void mousePressed(int x, int y){}
    public void update(){}
    public void draw(Graphics2D g){}

    public class KeyInput implements KeyListener {

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

    public class MouseInput implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            GamePanel.this.mousePressed(e.getX(),e.getY());
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

    }
}
