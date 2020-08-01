/**
 * this class represents a battleship on the game table
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Battleship {
    // battleship variables
    private int length; // [1, 4]
    private boolean isVertical;

    public Battleship(int length, boolean isVertical) {
        this.length = length;
        this.isVertical = isVertical;
    }
}
