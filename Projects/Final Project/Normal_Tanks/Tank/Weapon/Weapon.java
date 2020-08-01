package game.Tank.Weapon;

import game.Object;

public class Weapon extends Object {

    protected int ammo; // remaining ammo

    public Weapon(int locationX, int locationY, String weaponPicLoc) {
        super(locationX, locationY, weaponPicLoc);
    }

    public boolean shootWeapon(){
        if(this.getAmmo() == 0)
            return false;
        else{
            this.ammo--;
            return true;
        }
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
