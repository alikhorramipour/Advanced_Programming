/**
 * this class represents a wolf
 * is a subclass of the class Animal
 */
public class Wolf extends Animal{
    /**
     * constructor for the class Wolf
     */
    public Wolf() {
        this.isAlive = true;

        this.firstDamageName = "kill";
        this.firstDamageAmount = 700;

        this.energy = 700;
        this.health = 450;
    }
}
