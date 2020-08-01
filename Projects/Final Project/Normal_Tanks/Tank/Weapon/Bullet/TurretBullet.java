package game.Tank.Weapon.Bullet;

import javax.imageio.ImageIO;
import java.io.File;

public class TurretBullet extends Bullet {

    public TurretBullet(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/LightBullet.png");
        this.damage = 6;
        this.speed = 1;
    }
}
