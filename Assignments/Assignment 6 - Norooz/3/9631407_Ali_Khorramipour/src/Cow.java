/**
 * this class represents a cow
 * is a subclass of the class Animal
 */
public class Cow extends Animal{
    /**
     * constructor for the class Cow
     */
    public Cow() {
        this.isAlive = true;

        this.firstDamageName = "attack";
        this.firstDamageAmount = 90;

        this.secondDamageName = "injure";
        this.secondDamageAmount = 100;

        this.energy = 400;
        this.health = 750;
    }
}
