package game.MapComponents;

import game.Object;

import java.awt.*;

public class Stone extends Object {

    public Stone(int locationX, int locationY){
        super(locationX, locationY, "src/Resources/Images/stone.png");
        this.setBreakable(false);
        this.setPassable(false);
    }
}
