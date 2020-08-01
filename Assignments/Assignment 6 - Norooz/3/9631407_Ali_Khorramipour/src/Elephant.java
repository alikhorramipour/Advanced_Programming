/**
 * this class represents a elephant
 * is a subclass of the class Animal
 */
public class Elephant extends Animal{
    /**
     * constructor for the class Elephant
     */
    public Elephant() {
        this.isAlive = true;

        this.firstDamageName = "hurt";
        this.firstDamageAmount = 70;

        this.secondDamageName = "attack";
        this.secondDamageAmount = 50;

        this.energy = 500;
        this.health = 1200;
    }
}
