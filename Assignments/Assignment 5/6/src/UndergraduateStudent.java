/**
 * this class represents an undergrad student
 * @author Ali Khorramipour
 * @version 1.0
 */
public class UndergraduateStudent extends Student{
    private final int courses = 140;
    private String scholarship;

    public UndergraduateStudent(String firstName, String lastName, String id, String scholarship) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setId(id);
        this.scholarship = scholarship;
    }

    public void displayStudentInformation(){
        super.displayInfo();
        System.out.println("Number of courses: 140");
        System.out.println("Scholarship: " + scholarship);
    }

    public int getCourses() {
        return courses;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }
}
