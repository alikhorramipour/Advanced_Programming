/**
 *The Student class represents a student in a student
 administration system.
 * It holds the student details relevant in our context. *
 * @author Ali
 * @version 1.0
 */
public class Student {
    //the student's first name
    private String firstName;

    //the student's last name
    private String lastName;

    //the student ID
    private String id;

    //the grade
    private int grade;

    /**
     * This constructor creates an instance of the object student.
     * @param fName = First name
     * @param lName = Last name
     * @param sID = Student id
     */
    public Student(String fName, String lName, String sID) {
        firstName = fName;
        lastName = lName;
        id = sID;
        grade = 0;
    }

    /**
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param fName = First name
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lName = Last name
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * @return Grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grde = Grade
     */
    public void setGrade(int grde) {
        grade = grde;
    }

    /**
     *
     * @return Student's id
     */
    public String getId(){
        return id;
    }

    /**
     *
     * @param Student's id = New identification
     */
    public void setId(String iden){
        id = iden;
    }

    /**
     * Prints out student's information
     */
    public void print() {
        System.out.println(lastName + ", Student ID:" + id + ", grade: " + grade);
    }
}
