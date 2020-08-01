/**
 * this class represents a lion
 * is a subclass of the class Animal
 */
public class Lion extends Animal{
    /**
     * constructor for the class Lion
     */
    public Lion() {
        this.isAlive = true;

        this.firstDamageName = "injure";
        this.firstDamageAmount = 150;

        this.secondDamageName = "kill";
        this.secondDamageAmount = 500;

        this.energy = 1000;
        this.health = 900;
    }
}
