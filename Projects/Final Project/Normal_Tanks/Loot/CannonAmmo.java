package game.Loot;

import game.Object;

import java.awt.*;

import static game.Tank.Weapon.PlayerTankCannon.PLAYER_TANK_CANNON;

public class CannonAmmo extends Loot{
    public CannonAmmo(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/CannonFood.png");
    }

    public boolean checkCollision(Rectangle rect){
        if(this.getObjectDimensions().intersects(rect) && !this.isUsed()) {
            PLAYER_TANK_CANNON.setAmmo(PLAYER_TANK_CANNON.getAmmo() + 20);
            return true;
        }
        else
            return false;
    }
}
