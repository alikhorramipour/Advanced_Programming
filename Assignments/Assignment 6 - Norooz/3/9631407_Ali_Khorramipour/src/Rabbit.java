/**
 * this class represents a rabbit
 * is a subclass of the class Animal
 */
public class Rabbit extends Animal{
    /**
     * constructor for the class Rabbit
     */
    public Rabbit() {
        this.isAlive = true;

        this.firstDamageName = "bite";
        this.firstDamageAmount = 80;

        this.energy = 350;
        this.health = 200;
    }
}
