package game.Loot;

import game.Object;

import java.awt.*;

import static game.Tank.PlayerTank.PLAYER_TANK;
import static game.Tank.Weapon.PlayerTankCannon.PLAYER_TANK_CANNON;
import static game.Tank.Weapon.PlayerTankTurret.PLAYER_TANK_TURRET;

public class UpgradeWeapon extends Loot {
    public UpgradeWeapon(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/StartupStar.png");
    }

    public boolean checkCollision(Rectangle rect) {
        if (this.getObjectDimensions().intersects(rect) && !this.isUsed()) {
            if (PLAYER_TANK.isTurret()) {
                PLAYER_TANK_TURRET.upgradeTurret();
                return true;
            } else {
                PLAYER_TANK_CANNON.upgradeCannon();
                return true;
            }
        } else
            return false;
    }
}
