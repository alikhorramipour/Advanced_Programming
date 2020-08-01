package game.MapComponents;

import game.Object;

public class Pipe extends Object {

    public Pipe(int locationX, int locationY){
        super(locationX, locationY, "src/Resources/Images/pipe.png");
        this.setBreakable(false);
        this.setPassable(true);
    }
}
