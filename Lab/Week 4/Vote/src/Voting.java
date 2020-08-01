import java.util.*;

/**
 * This class represents the voting itself.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Voting {
    //zero for "one vote system" and one for "multiple vote system"
    private int mode;

    Iterator it, it1;

    HashMap<String, HashSet<Vote>> choices;
    private String question;

    public String getQuestion() {
        return question;
    }

    public Voting(int mode, String question) {
        this.mode = mode;
        this.question = question;
        choices = new HashMap<>();
    }

    public void createChoice(String choiceName){
        choices.put(choiceName, new HashSet<>());
    }

    public void vote(Person voter, ArrayList<String> votes){
        if(mode == 1) {
            it1 = votes.iterator();
            while (it1.hasNext()) {
                String vt = it1.next().toString();
                if (choices.containsKey(vt))
                    choices.get(vt).add(new Vote(voter));
            }
        }else{
            if(choices.containsKey(votes.get(0)))
            choices.get(votes.get(0)).add(new Vote(voter));
        }
    }

    public void printResult(){
        it = choices.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
