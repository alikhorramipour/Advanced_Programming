package game;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * abstract class for defining objects
 */

public class Object {
    private boolean isPassable;
    private boolean isBreakable;
    private int locationX, locationY;
    //private String picLocation;
    private Rectangle objectDimensions;
    public BufferedImage picture;


    public Object(int locationX, int locationY, String picLoc) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.objectDimensions = new Rectangle(locationX, locationY, 100, 100);
        try{
            this.picture = ImageIO.read(new File(picLoc));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Object(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.objectDimensions = new Rectangle(locationX, locationY, 100, 100);
    }

    public Object(String picLoc) {
        try{
            this.picture = ImageIO.read(new File(picLoc));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean passable) {
        isPassable = passable;
    }

    public boolean isBreakable(boolean b) {
        return isBreakable;
    }

    public void setBreakable(boolean breakable) {
        isBreakable = breakable;
    }

    protected void setPicture(String picLoc) {
        try{
            this.picture = ImageIO.read(new File(picLoc));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public BufferedImage getPicture() {
        return picture;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Rectangle getObjectDimensions() {
        return objectDimensions;
    }

    public boolean checkCollision(Rectangle rect){
        return this.getObjectDimensions().intersects(rect);
    }

    public boolean checkCollisionWithAll(ArrayList<Object> objects){
        for (Object obj1 : objects) {
            if (!obj1.isPassable()) {
                if (obj1.checkCollision(this.getObjectDimensions())) {
                    return true;
                }
            }
        }
        return false;
    }

}
