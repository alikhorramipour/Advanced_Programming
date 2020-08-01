import java.util.ArrayList;

/**
 * This class represents a vehicle registration plate.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Plate {
    // variables
    private String id, firstName, lastName;
    private boolean validity;
    private ArrayList<String> fine = new ArrayList<String>();

    /**
     * constructor for the class plate
     * @param id : plate numbers and characters
     * @param firstName : first name of the owner
     * @param lastName : last name of the owner
     */
    public Plate(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.validity = true;
    }

    /**
     * this method prints out the violation records
     */
    public void printFine(){
        System.out.println(fine);
    }

    /**
     * this method adds a fine to the list
     * @param declaration: description for the violation committed by the owner
     */
    public void addFine(String declaration){
        fine.add(declaration);
        if(fine.size() >= 10)
            this.validity = false;
    }

    /**
     * this method removes a fine from the list
     * @param declaration: description for the violation committed by the owner
     */
    public void forgiveFine(String declaration) {
        for (int i = 0; i < fine.size(); i++) {
            if (fine.get(i) == declaration)
                fine.remove(i);
        }
        if (fine.size() < 5)
            this.validity = true;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isValidity() {
        return validity;
    }

    public ArrayList<String> getFine() {
        return fine;
    }
}
