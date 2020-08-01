package game.Loot;

import game.Object;

import java.awt.*;

import static game.Tank.PlayerTank.PLAYER_TANK;

public class HealthPack extends Loot {
    public HealthPack(int locationX, int locationY){
        super(locationX, locationY, "src/Resources/Images/RepairFood.png");
    }

    public boolean checkCollision(Rectangle rect){
        if(this.getObjectDimensions().intersects(rect) && !this.isUsed()) {
            PLAYER_TANK.setHealthPoint(PLAYER_TANK.getHealthPoint() + 20);
            return true;
        }
        else
            return false;
    }
}


