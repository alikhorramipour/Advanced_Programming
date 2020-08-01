package game.Loot;

import game.Object;

import java.awt.*;

import static game.Tank.Weapon.PlayerTankTurret.PLAYER_TANK_TURRET;

public class TurretAmmo extends Loot {

    public TurretAmmo(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/MashinGunFood.png");
    }

    public boolean checkCollision(Rectangle rect){
        if(this.getObjectDimensions().intersects(rect) && !this.isUsed()) {
            PLAYER_TANK_TURRET.setAmmo(PLAYER_TANK_TURRET.getAmmo() + 50);
            return true;
        }
        else
            return false;
    }
}
