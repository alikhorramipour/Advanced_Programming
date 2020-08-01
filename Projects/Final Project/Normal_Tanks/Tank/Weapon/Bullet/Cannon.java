package game.Tank.Weapon.Bullet;

public class Cannon extends Bullet {
    public Cannon(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/HeavyBullet.png");
        this.damage = 20;
        this.speed = .7;
    }
}
