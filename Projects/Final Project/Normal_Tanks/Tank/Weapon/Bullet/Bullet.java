package game.Tank.Weapon.Bullet;

import game.Object;
import game.Tank.Tank;
import game.bufferstrategy.GameFrame;
import game.bufferstrategy.GameState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import static game.Tank.PlayerTank.PLAYER_TANK;

/**
 * this class represents the ammunition used in the game
 */

public class Bullet extends Object {

    protected double damage; // damage of the bullet
    protected double speed; // speed of the bullet
    private AffineTransform bulletTransform = new AffineTransform();

    public Bullet(int locationX, int locationY, String picLoc) {
        super(locationX, locationY, picLoc);
    }

    public boolean checkCollisionWithAll(ArrayList<Object> objects) {
        for (Object obj1 : objects) {
            if (!obj1.isPassable() && obj1.checkCollision(this.getObjectDimensions()))
                if (obj1 instanceof Tank) {
                    ((Tank) obj1).setHealthPoint(((Tank) obj1).getHealthPoint() - this.damage);
                    return true;
                }
        }
        return true;
    }

    public void fireBullet(Tank tank, ArrayList<Object> objects, Graphics2D g2d, GameState gameState) {
        int xTmp = tank.getLocationX();
        int yTmp = tank.getLocationY();
        bulletTransform.rotate(Math.atan2(gameState.mouseY, gameState.mouseX));
        while(this.checkCollisionWithAll(objects)){
            bulletTransform.setToTranslation(xTmp, yTmp);
            xTmp += (xTmp*speed);
            yTmp += (yTmp*speed);
            g2d.drawImage(this.getPicture(), bulletTransform, null);
        }
    }
}
