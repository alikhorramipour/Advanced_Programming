/**
 * this class represents a boar
 * is a subclass of the class Animal
 */
public class Boar extends Animal{
    /**
     * constructor for the class boar
     */
    public Boar() {
        this.isAlive = true;

        this.firstDamageName = "hurt";
        this.firstDamageAmount = 80;

        this.energy = 500;
        this.health = 1100;
    }
}
