package game.MapComponents;

import game.Object;

/**
 * demonstrates dirt in the game map
 */

public class Dirt extends Object {

    public Dirt(int locationX, int locationY) {
        super(locationX, locationY, "src/Resources/Images/Soil.png");
        this.setBreakable(false);
        this.setPassable(true);
    }

}
