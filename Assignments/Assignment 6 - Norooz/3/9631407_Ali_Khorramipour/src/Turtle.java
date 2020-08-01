/**
 * this class represents a turtle
 * is a subclass of the class Animal
 */
public class Turtle extends Animal{
    /**
     * constructor for the class Turtle
     */
    public Turtle() {
        this.isAlive = true;

        this.firstDamageName = "bite";
        this.firstDamageAmount = 200;

        this.energy = 230;
        this.health = 350;
    }
}
