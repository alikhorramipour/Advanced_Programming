package game.Tank.Weapon;

import game.Tank.Weapon.Bullet.TurretBullet;

import java.util.ArrayList;

public class PlayerTankTurret extends Weapon {

    private double turretUpgrade = 1; // sets the amount of turretDamage Multiplier

    public static PlayerTankTurret PLAYER_TANK_TURRET = new PlayerTankTurret(100, 100);
    public ArrayList<TurretBullet> turretBullets = new ArrayList<>();

    public PlayerTankTurret(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/tankgun01.png");
        this.setAmmo(300);
    }

    public double getTurretUpgrade() {
        return turretUpgrade;
    }

    public void upgradeTurret() {
        this.turretUpgrade *= 1.2;
    }
}
