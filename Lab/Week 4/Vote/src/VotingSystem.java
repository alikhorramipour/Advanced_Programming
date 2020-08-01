import java.util.*;

/**
 * This class represents the voting system.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class VotingSystem {
    ArrayList <Voting> votingList = new ArrayList<>();
    Iterator it;

    public void createVoting(int mode, String question){
        votingList.add(new Voting(mode, question));
    }

    public void printListOfVotings(){
        it = votingList.iterator();
        while(it.hasNext()){
            Voting tmpVote = (Voting)it.next();
            System.out.println(tmpVote.getQuestion());
        }
    }

    public void printVoting(int index){
        System.out.println("Question: " + votingList.get(index).getQuestion());
        System.out.println("Choices: ");
        Set set = votingList.get(index).choices.entrySet();
        Iterator it = set.iterator();
        int i=0;
        while(it.hasNext()){
            Map.Entry temp = (Map.Entry)it.next();
            System.out.println(++i + ") " + temp.getKey());
        }
    }

    public void createChoice(String choiceName, int index){
        votingList.get(index).createChoice(choiceName);
    }

    public void vote (int index, Person voter, ArrayList<String> votes){
        votingList.get(index).vote(voter, votes);
    }

    public void printResult(int index){
        votingList.get(index).printResult();
    }
}
