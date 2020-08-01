package game.MapComponents;

import game.Object;

public class Plant extends Object {

    public Plant(int locationX, int locationY){
        super(locationX, locationY, "src/Resources/Images/plant.png");
        this.setBreakable(false);
        this.setPassable(true);
    }
}
