package game.MapComponents;

import game.Object;
import game.bufferstrategy.GameState;

import java.awt.*;

public class Wall extends Object {
    private static final String picLocation[] = {"src/Resources/Images/softWall.png",
            "src/Resources/Images/softWall1.png", "src/Resources/Images/softWall2.png",
            "src/Resources/Images/softWall3.png"};

    private int state = 0;

    public Wall(int locationX, int locationY){
        super(locationX, locationY, "src/Resources/Images/softWall.png");
        this.setBreakable(true);
        this.setPassable(false);
    }

    public void breakWall(){
        this.state++;
        this.setPicture(this.picLocation[state]);
        if(state == 3) {
            this.setBreakable(false);
            this.setPassable(true);
        }
    }

    public String showState(){
        return picLocation[state];
    }
}
