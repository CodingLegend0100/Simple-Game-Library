package gamelib;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//DO NOT EDIT THIS CLASS
//Unless you know what you're doing
//Then you may
/** This class is intended for displaying static images onto the screen */
public class Sprite {
    protected double x, y; //Represents the sprites CENTER x and y
    protected double velX, velY, rotationSpeed;
    protected int width,height;
    protected double rotation; //Rotation in degrees
    protected Image i;

    /**Create a blank sprite */
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
        setImage(i);
    }

    /**Loads the image from the string filepath */
    public static Image loadImage(String imagePath){
        return new ImageIcon(imagePath).getImage();
    }

    //Getters
    public double getX(){ return x; }
    public double getY(){ return y; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
    public double getRotation(){ return rotation; }
    public Image getImage(){ return i; }

    //Setters
    public void setX(double x){ this.x = x; }
    public void setY(double y){ this.y = y; }
    public void setPos(double x, double y){ this.x = x; this.y = y; }
    public void setVelX(double x){ velX = x; }
    public void setVelY(double y){ velY = y; }
    public void setVelocity(double x, double y){ velX = x; velY = y; }
    public void setWidth(int width){ this.width = width; }
    public void setHeight(int height){ this.height = height; }
    public void setRotation(double degrees){ this.rotation = degrees; }
    public void setRotationSpeed(double degrees){ rotationSpeed = degrees; }
    public void setImage(Image i){ this.i = i; }

    //Ignores rotation
    public boolean checkCollision(Sprite s){
        //If this.right > s.left && this.left < s.right && this.bottom > s.top && this.top < s.bottom
        Rectangle r1 = new Rectangle((int)x-width/2,(int)y-height/2,width,height);
        Rectangle r2 = new Rectangle((int)s.x-s.width/2,(int)s.y-s.height/2,s.width,s.height);
        return r1.intersects(r2) || r1.contains(r2) || r2.contains(r1);
    }

    //Also ignores rotation
    /** Checks if the specified point is is contained within the sprite */
    public boolean contains(int x,int y){
        return this.x < x && this.y < y && this.x+width > x && this.y+height > y;
    }

    /** Returns an ArrayList of sprites that this sprite is colliding with */
    public ArrayList<Sprite> checkCollisionList(ArrayList<Sprite> sprites){
        ArrayList<Sprite> colliding = new ArrayList<Sprite>();
        for (Sprite s : sprites){
            if (checkCollision(s)){
                colliding.add(s);
            }
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
        if (i == null) return; //Dont draw if there is no image

        double rotate = Math.toRadians(rotation);

        g.rotate(rotate,x,y); //Rotate the canvas centered on the sprite
        
        g.drawImage(i,(int)x-width/2,(int)y-height/2,width,height,null);

        g.rotate(-rotate,x,y); //Rotate the canvas back to original

    }
}