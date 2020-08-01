/**
 * this class represents a fox
 * is a subclass of the class Animal
 */
public class Fox extends Animal{
    /**
     * constructor for the class Fox
     */
    public Fox() {
        this.isAlive = true;

        this.firstDamageName = "injure";
        this.firstDamageAmount = 90;

        this.energy = 600;
        this.health = 400;
    }
}
