import gamelib.*;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Main extends GamePanel {
    static int WIDTH = 900, HEIGHT = 600; //The dimensions of the window
    static int FPS = 60; //Desired frames per second
    static Color BACKGROUND = Color.WHITE; //Background color
    public static void main(String[] args){
        //Initialize the game window
        JFrame window = new JFrame("Space Miner");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new Main());
        window.pack();
        window.setIconImage(Sprite.loadImage("assets/spaceship.png"));
        window.setVisible(true);
    }

    public Main(){ super(WIDTH,HEIGHT,FPS,BACKGROUND); }

    public void keyPressed(String key){
    
    
    }

    public void keyReleased(String key){

    
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
