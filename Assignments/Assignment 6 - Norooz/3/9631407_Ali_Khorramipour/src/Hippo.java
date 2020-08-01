/**
 * this class represents a hippo
 * is a subclass of the class Animal
 */
public class Hippo extends Animal{
    /**
     * constructor for the class Hippo
     */
    public Hippo() {
        this.isAlive = true;

        this.firstDamageName = "attack";
        this.firstDamageAmount = 110;

        this.energy = 360;
        this.health = 1000;
    }
}
