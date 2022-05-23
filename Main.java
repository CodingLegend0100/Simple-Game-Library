import gamelib.*;

import java.awt.Graphics2D;
import javax.swing.JFrame;

public class Main extends GamePanel {
    public static void main(String[] args){
        //Initialize the game window
        JFrame window = new JFrame("New Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new Main());
        window.pack();
        window.setVisible(true);
    }

    public Main(){
        super(900,600);
        FPS = 60;
        //Initialize your instance variables here



        start();
    }

    public void keyPressed(String key){
    
    }

    public void keyReleased(String key){

    }

    public void mousePressed(int x, int y){

    }

    public void update(){
        //Update the positions of objects on the screen
    
    }

    public void draw(Graphics2D g){
        /*Documentation for Graphics and Graphics2D classes
        https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html
        */

        //Draw objects to the screen
    }
}
