/**
 * This class represents an employee.
 * @author Ali Khorramipour
 * @version 1.0
 */

public class Employee {
    // variables of the class
    private String firstName, lastName, firstNameOfSpouse, lastNameOfSpouse;
    private int age, numberOfChildren;

    /**
     * first construtor for the class employee
     */
    public Employee(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * second constructor for the class employee
     */
    public Employee(String firstName, String lastName, int age, String firstNameOfSpouse, String lastNameOfSpouse){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.firstNameOfSpouse = firstNameOfSpouse;
        this.lastNameOfSpouse = lastNameOfSpouse;
    }

    /**
     * method for increasing the numberOfChildren
     * @param amount: added child(s)
     */
    public void addChild(int amount){
        if(amount < 1)
            System.out.println("Enter a valid number!!");
        this.numberOfChildren += amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstNameOfSpouse() {
        return firstNameOfSpouse;
    }

    public String getLastNameOfSpouse() {
        return lastNameOfSpouse;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}
