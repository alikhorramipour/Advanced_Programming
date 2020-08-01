package game.Tank.Weapon;

import game.Object;
import game.Tank.Weapon.Bullet.Cannon;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import static game.Tank.PlayerTank.PLAYER_TANK;

public class PlayerTankCannon extends Weapon {

    private double cannonUpgrade = 1; // sets the amount of cannonDamage Multiplier

    public static PlayerTankCannon PLAYER_TANK_CANNON = new PlayerTankCannon(100, 100);
    public ArrayList<Cannon> cannons = new ArrayList<>();

    public PlayerTankCannon(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/tankgun1.png");
        this.setAmmo(50);
    }

    public double getCannonUpgrade() {
        return cannonUpgrade;
    }

    public void upgradeCannon() {
        this.cannonUpgrade *= 1.2;
    }
}
