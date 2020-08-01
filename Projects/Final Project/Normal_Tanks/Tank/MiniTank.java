package game.Tank;

import game.Tank.Weapon.Weapon;

/**
 * this class represents a mini tank
 */
public class MiniTank extends Tank {
    public Weapon miniTankWeapon;

    public MiniTank(int locationX, int locationY, String difficulty, boolean animated) {
        super(locationX, locationY, "src/Resources/Images/SmallEnemy.png");
        if(difficulty.equals("easy"))
            setHealthPoint(25);
        else if(difficulty.equals("normal"))
            setHealthPoint(50);
        else
            setHealthPoint(75);
        setAdversary(true);
        setAnimated(animated);
        setLife(1);
        if (animated) {
            this.miniTankWeapon = new Weapon(locationX, locationY, "src/Resources/Images/SmallEnemyGun.png");
        }
        else {
            this.miniTankWeapon = new Weapon(locationX, locationY, "src/Resources/Images/BigEnemyGun.png");
        }
        this.miniTankWeapon.setAmmo(-1);
    }
}
