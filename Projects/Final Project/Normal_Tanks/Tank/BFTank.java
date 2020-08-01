package game.Tank;

/**
 * this class represents a big tank
 */


import game.Tank.Weapon.Weapon;

public class BFTank extends Tank {

    public Weapon bftankWeapon;

    public BFTank(int locationX, int locationY, String difficulty, boolean animated) {
        super(locationX, locationY, "src/Resources/Images/BigEnemy.png");
        if (difficulty.equals("easy"))
            setHealthPoint(50);
        else if (difficulty.equals("normal"))
            setHealthPoint(75);
        else
            setHealthPoint(100);
        setAdversary(true);
        setAnimated(animated);
        setLife(1);
        if (animated) {
            this.bftankWeapon = new Weapon(locationX, locationY, "src/Resources/Images/BigEnemyGun.png");
        }
        else {
            this.bftankWeapon = new Weapon(locationX, locationY, "src/Resources/Images/tankGun1.png");
        }
        this.bftankWeapon.setAmmo(-1);
    }
}
