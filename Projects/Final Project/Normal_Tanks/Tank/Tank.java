package game.Tank;

import game.Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 * this class represents a tank
 */
public class Tank extends Object {
    private int life; // determines how many life the tank has
    private double healthPoint; // health points of the tank
    private boolean adversary; // sets whether the tank is player controlled(0) or not(1)
    private boolean animated; // sets whether the tank is stationary(0) or not(1)
    private boolean lootable; // determines whether when the tank is destroyed, it drops a loot box or not

    public Tank(int locationX, int locationY, String bodyPicLoc) {
        super(locationX, locationY, bodyPicLoc);
        setPassable(false);
    }

    protected int getLife() {
        return life;
    }

    protected void setLife(int life) {
        this.life = life;
    }

    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    protected boolean isAdversary() {
        return adversary;
    }

    protected void setAdversary(boolean adversary) {
        this.adversary = adversary;
    }

    protected boolean isAnimated() {
        return animated;
    }

    protected void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public boolean isLootable() {
        return lootable;
    }

    public void setLootable(boolean lootable) {
        this.lootable = lootable;
    }

    /*
    public void printTank(Graphics2D g2d){
        // Get a new graphics context to render the current frame
        try {
            // Do the rendering
            BufferedImage bufferedImageBody = ImageIO.read(getClass().getResource(bodyPicLoc));
            BufferedImage bufferedImageGun = ImageIO.read(getClass().getResource(gunPicLoc));
        } catch(Exception e){
            e.printStackTrace();
        }
        // Display the buffer
        // Tell the system to do the drawing NOW;
        // otherwise it can take a few extra ms and will feel jerky!
        //Toolkit.getDefaultToolkit().sync();
    }
    */
}
