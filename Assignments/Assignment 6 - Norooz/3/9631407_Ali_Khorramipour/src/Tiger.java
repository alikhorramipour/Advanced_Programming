/**
 * this class represents a tiger
 * is a subclass of the class Animal
 */
public class Tiger extends Animal{
    /**
     * constructor for the class Tiger
     */
    public Tiger() {
        this.isAlive = true;

        this.firstDamageName = "injure";
        this.firstDamageAmount = 120;

        this.secondDamageName = "kill";
        this.secondDamageAmount = 650;

        this.energy = 850;
        this.health = 850;
    }
}
