import java.util.Random;

/**
 * the main class for executing the program.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        Person p1 = new Person("fn", "ln");

        VotingSystem vs1 = new VotingSystem();

        Random rand = new Random();

        vs1.createVoting(0, "Change map?");
        vs1.createChoice("map1", 0);

        vs1.printVoting(0);

    }
}
