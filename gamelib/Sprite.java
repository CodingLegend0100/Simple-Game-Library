package gamelib;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//DO NOT EDIT THIS CLASS
/** This class is intended for displaying static images onto the screen */
public class Sprite {
    public double x, y; //Represents the sprites CENTER x and y
    public double velX, velY;
    public int width,height;
    public double rotation; //Rotation in degrees
    public double rotationSpeed;
    public Image image;

    /** Blank constructor for a blank sprite */
    public Sprite(){}

    /**Create a sprite whose size will be inherited from the image's width and height */
    public Sprite(String image,double x,double y){
        this(loadImage(image),x,y);
    }

    /**Create a sprite whose size will be inherited from the image's width and height */
    public Sprite(Image i,double x,double y){
        this(i,x,y,i.getWidth(null),i.getHeight(null));
    }

    /**Create a sprite whose size will be inherited from the image's scaled size */
    public Sprite(String image,double x,double y,double scale){
        this(loadImage(image),x,y,scale);
    }
    
    /**Create a sprite whose size will be inherited from the image's scaled size */
    public Sprite(Image i,double x,double y,double scale){
        this(i,x,y,(int)(i.getWidth(null)*scale),(int)(i.getHeight(null)*scale));
    }

    /**Create a sprite with the predetermined position and size */
    public Sprite(String image,double x,double y,int width,int height){
        this(loadImage(image),x,y,width,height);
    }

    /**Create a sprite with the predetermined position and size */
    public Sprite(Image i,double x,double y,int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        image = i;
    }

    /**Loads the image from the string filepath */
    public static Image loadImage(String imagePath){
        return new ImageIcon(imagePath).getImage();
    }

    //Setters
    public void setPos(double x, double y){ this.x = x; this.y = y; }
    public void setSize(int w, int h){ width = w; height = h; }


    public boolean checkCollision(Sprite s){
        //If this.right > s.left && this.left < s.right && this.bottom > s.top && this.top < s.bottom
        Rectangle collide1 = new Rectangle((int)x+width/2,(int)y+height/2,width,height);
        Rectangle collide2 = new Rectangle((int)s.x-s.width/2,(int)s.y-s.height/2,s.width,s.height);
        return collide1.intersects(collide2) || collide1.contains(collide2) || collide2.contains(collide1);
    }

    public ArrayList<Sprite> checkCollisionList(ArrayList<Sprite> sprites){
        ArrayList<Sprite> colliding = new ArrayList<Sprite>();
        for (Sprite s : sprites){
            if (checkCollision(s)) colliding.add(s);
        }
        return colliding;
    }

    public void update(){
        x += velX;
        y += velY;
        rotation += rotationSpeed;
    }

    /** Draws the sprite */
    public void draw(Graphics2D g){
        if (image == null) return; //Dont draw if there is no image

        double rotate = Math.toRadians(rotation);

        g.rotate(rotate,x,y); //Rotate the canvas centered on the sprite
        
        g.drawImage(image,(int)x-width/2,(int)y-height/2,width,height,null);

        g.rotate(-rotate,x,y); //Rotate the canvas back to original

    }
}