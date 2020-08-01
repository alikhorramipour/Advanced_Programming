/**
 * this class represents a bear
 * is a subclass of the class Animal
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Bear extends Animal{
    /**
     * constructor for the class Bear
     */
    public Bear() {
        this.isAlive = true;

        this.firstDamageName = "injure";
        this.firstDamageAmount = 130;

        this.secondDamageName = "kill";
        this.secondDamageAmount = 600;

        this.energy = 900;
        this.health = 850;
    }
}
