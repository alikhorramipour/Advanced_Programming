/**
 * @author Ali
 * @version 1.0
 * This class represents items of a store.
 */
public class Item {
    // instance variables
    private String name;
    private String producer;
    private int amount;

    /**
     * Increment
     * @param amount: the amount of an item that is supposed to increase
     */
    public void increment(int amount){
        if (amount < 0)
            System.out.println("Not possible!");
        else
            this.amount += amount;
    }

    /**
     * Decrement
     * @param amount: the amount of an item that is supposed to decrease
     */
    public void decrement(int amount){
        if (amount < 0)
            System.out.println("Not possible!");
        if(this.amount - amount < 0)
            System.out.println("Not that much remaining!!");
        else
            this.amount -= amount;
    }

    /**
     * This method prints out item's info.
     */
    public void print(){
        System.out.println("Name of the product is: " + name);
        System.out.println("Producer name is: " + producer);
        System.out.println("Remaining amount is: " + amount + "\n");
    }
    /**
     * Constructor for the item.
    */
    public Item(String name, String producer) {
        this.name = name;
        this.producer = producer;
        amount = 0;
    }

    public static void main(String[] args){
        Item coco = new Item("Chocolate", "Farmand");
        Item puff = new Item("Puff", "Chuckles");

        coco.increment(5);
        puff.increment(3);

        coco.print();
        puff.print();
    }
}
