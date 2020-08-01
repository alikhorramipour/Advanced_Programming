package game.Loot;

import game.Object;

public class Loot extends Object {
    private boolean used = false;

    public Loot(int locationX, int locationY, String picLoc) {
        super(locationX, locationY, picLoc);
        this.setPassable(true);
    }

    public boolean isUsed(){
        return used;
    }

    public void setUsed() {
        used = true;
    }
}
