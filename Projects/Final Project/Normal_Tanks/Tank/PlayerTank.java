package game.Tank;


import game.bufferstrategy.GameFrame;
import game.bufferstrategy.GameState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static game.Tank.Weapon.PlayerTankCannon.PLAYER_TANK_CANNON;
import static game.Tank.Weapon.PlayerTankTurret.PLAYER_TANK_TURRET;

/**
 * this class represents the player's tank
 */

public class PlayerTank extends Tank {

    public static PlayerTank PLAYER_TANK = new PlayerTank(100, 100);

    private boolean isTurret = true; // true for turret and false for cannon

    private BufferedImage health, healthMiss, turretAmmoRemaining, cannonAmmoRemaining;

    public PlayerTank(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/tank.png");
        try {
            health = ImageIO.read(new File("src/Resources/Images/health.png"));
            healthMiss = ImageIO.read(new File("src/Resources/Images/healthMiss.png"));
            turretAmmoRemaining = ImageIO.read(new File("src/Resources/Images/NumberOfMachinGun2.png"));
            cannonAmmoRemaining = ImageIO.read(new File("src/Resources/Images/NumberOfHeavyBullet2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLife(3);
        setAdversary(false);
        setAnimated(true);
        setHealthPoint(100);
    }

    public boolean isTurret() {
        return isTurret;
    }

    public void changeWeapon() {
        this.isTurret = !this.isTurret;
    }

    public Rectangle getBounds() {
        return new Rectangle(getLocationX() + 10, getLocationY() + 10,
                90, 90);
    }

    public boolean shootWeapon() {
        if (isTurret()) {
            if (PLAYER_TANK_TURRET.shootWeapon()) {
                return true;
            } else
                return false;
        } else {
            if (PLAYER_TANK_CANNON.shootWeapon()) {
                return true;
            } else
                return false;
        }
    }

    public void printTank(Graphics2D g2d, GameState state, int mouseLocationX, int mouseLocationY) {
        /* rotation of the body of the tank
        affineTransform.setToTranslation((state.locX + 50 - (state.locX - 100)), (state.locY + 50 - (state.locY - 100)));
        affineTransform.rotate(Math.PI * state.get);
        affineTransform.translate(-50, -50);
        */


        // rotation of the gun of the PLAYER_TANK

        //gunTransform.translate(5, 0);

        //gunTransform.setToTranslation(state.locX + 19, 100 + 17);
        //gunTransform.setToTranslation(0, 0);
        //double angle = Math.atan2(mouseLocationY, mouseLocationX);
        //gunTransform.setToTranslation(StrictMath.cos(angle) * (state.locX + 19) - StrictMath.sin(angle) * 117,0);
        //gunTransform.rotate(Math.atan2(mouseLocationY, mouseLocationX) * 1.15,  state.locX + 15,
        //      state.locY);
        //gunTransform.rotate(mouseLocationX, mouseLocationY, state.locX+15, 115);

        //localX = turret.centerCannonLength;
        //localY = 0;

        //globalX = 25 + StrictMath.cos(angle) * state.locX - StrictMath.sin(angle) * 0;
        //globalY = 25 + StrictMath.sin(angle) * state.locX + StrictMath.cos(angle) * 0;


        //globalX = turret.location.x + cos(angle) * localX - sin(angle) * localY;
        //globalY = turret.location.y + sin(angle) * localX + cos(angle) * localY;

        g2d.drawImage(this.picture, this.getLocationX(), 100, null);
        AffineTransform gunTransform = new AffineTransform();
        gunTransform.setToTranslation(state.locX + 15, 100 + 15);
        gunTransform.rotate(Math.atan2(mouseLocationY, mouseLocationX) * 1.5);
        //gunTransform.rotate(mouseLocationX, mouseLocationY, state.locX+15, 115);

        if (this.isTurret()) {
            //g2d.drawImage(playerTankTurretImg, state.locX + 19, 100 + 17, null);
            g2d.drawImage(PLAYER_TANK_TURRET.getPicture(), gunTransform, null);
        } else {
            //g2d.drawImage(playerTankCannonImg, state.locX + 19, 100 + 17, null);
            g2d.drawImage(PLAYER_TANK_CANNON.getPicture(), gunTransform, null);
        }

    }

    public void drawFeatures(Graphics2D g2d, GameState state) {
        for (int i = 0; i < 3; i++) {
            if (i < this.getLife())
                g2d.drawImage(health, 1150, i * 100 + 100, null);
            else
                g2d.drawImage(healthMiss, 1150, i * 100 + 100, null);
        }
        g2d.drawImage(turretAmmoRemaining, 30, 150, null);
        g2d.setColor(Color.WHITE);
        //g2d.setFont(g2d.getFont().deriveFont(18.0f));
        g2d.drawString(String.valueOf(PLAYER_TANK_TURRET.getAmmo()), 30, 150);
        g2d.drawImage(cannonAmmoRemaining, 30, 250, null);
        g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf(PLAYER_TANK_CANNON.getAmmo()), 30, 250);
    }
}
