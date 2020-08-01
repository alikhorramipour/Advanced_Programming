import java.util.ArrayList;
import java.util.Random;

/**
 * this class represents a player's hand
 * @author Ali Khorramipour
 * @version 1.0
 */

public class PlayerHand {

    private static String[] id = {"Lion", "Bear", "Tiger", "Vulture", "Fox",
            "Elephant", "Wolf", "Boar", "Hippo", "Cow", "Rabbit", "Turtle"};

    public String getId(int index) {
        return id[index];
    }

    ArrayList<Animal> hand;

    private int[] howMuch = new int[12];

    public PlayerHand(){
        this.hand = new ArrayList<>();
    }

    public void makeHand(){
        Random r1 = new Random();
        int tempRan;
        while(this.hand.size() < 31) {
            tempRan = r1.nextInt(12);
            switch (tempRan){
                case 0:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                       hand.add(new Lion());
                       howMuch[tempRan]++;
                       break;
                    }
                    else
                        break;
                case 1:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Bear());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 2:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Tiger());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 3:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Vulture());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 4:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Fox());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 5:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Elephant());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 6:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Wolf());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 7:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Boar());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 8:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Hippo());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 9:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Cow());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 10:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Rabbit());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
                case 11:
                    if((howMuch[tempRan] < 6) && (howMuch[tempRan] > 0)){
                        hand.add(new Turtle());
                        howMuch[tempRan]++;
                        break;
                    }
                    else
                        break;
            }
        }
    }

    public void showHand(){
        for(int i = 0; i < 12; i++){
            if(howMuch[i] != 0)
                System.out.println(getId(i) + ": " + howMuch[i]);
        }
    }
}
