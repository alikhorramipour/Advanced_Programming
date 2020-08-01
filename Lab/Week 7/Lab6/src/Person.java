import java.util.ArrayList;

/**
 * this class represents a person.
 */

public class Person {
    ArrayList<Reserve> reserves;

    private String firstName;
    private String lastName;
    private int personPNumber;


    public Person(ArrayList<Reserve> reserves, String firstName, String lastName, int personPNumber) {
        this.reserves = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.personPNumber = personPNumber;
    }
}
