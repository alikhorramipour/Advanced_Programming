/**
 * this abstract class represents a student
 * @author Ali Khorramipour
 * @version 1.0
 */
abstract public class Student {
    private String firstName;
    private String lastName;
    private String id;

    /**
     * this method prints out student information
     */
    public void displayInfo(){
        System.out.println("Student name: " + firstName + " " + lastName + " and his/her id is: " + id);
    }

    /**
     * getter method for first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter method for the first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter method for last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter method for last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter method for student's id
     */
    public String getId() {
        return id;
    }

    /**
     * setter method for student's id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
