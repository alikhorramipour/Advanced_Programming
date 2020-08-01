/**
 * this class represents a vulture
 * is a subclass of the class Animal
 */
public class Vulture extends Animal{
    /**
     * constructor for the class Vulture
     */
    public Vulture() {
        this.isAlive = true;

        this.firstDamageName = "injure";
        this.firstDamageAmount = 100;

        this.energy = 600;
        this.health = 350;
    }
}
