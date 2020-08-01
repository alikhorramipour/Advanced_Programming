/**
 * this class represents an animal
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Animal {
    // boolean variable to determine if the animal is alive or not
    protected boolean isAlive;

    // first type of damage name and amount
    protected String firstDamageName;
    protected int firstDamageAmount;

    // second type of damage name and amount
    protected String secondDamageName;
    protected int secondDamageAmount;

    // health and energy of the animal
    protected int energy;
    protected int health;

    protected void firstDamage(Animal a2){
        if(this.firstDamageAmount > this.energy)
            System.out.println("This action cannot be completed!");
        else{
            this.energy -= this.firstDamageAmount;
            a2.health -= this.firstDamageAmount;
        }
    }

    protected void secondDamage(Animal a2){
        if((this.secondDamageAmount > this.energy) || a2.isAlive == false)
            System.out.println("This action cannot be completed!");
        else{
            this.energy -= this.secondDamageAmount;
            a2.health -= this.secondDamageAmount;
            if(a2.health <= 0)
                a2.isAlive = false;
        }
    }
}
