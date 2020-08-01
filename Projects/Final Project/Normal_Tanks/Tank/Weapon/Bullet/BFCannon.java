package game.Tank.Weapon.Bullet;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BFCannon extends Bullet {
    public BFCannon(int locationX, int locationY) {
        super(locationX, locationY,"src/Resources/Images/Missile.png");
        this.speed = .5;
        this.damage = 30;
    }
}
