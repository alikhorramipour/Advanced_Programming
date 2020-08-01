/**
 * this class represents a graduate student.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class GraduateStudent extends Student{
    private final int courses = 32;
    private String guiProf;
    private String underGradUni;

    /**
     * constructor for the class GraduateStudent
     * @param firstName
     * @param lastName
     * @param id
     * @param guiProf
     * @param underGradUni
     */
    public GraduateStudent(String firstName, String lastName, String id, String guiProf, String underGradUni) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setId(id);
        this.guiProf = guiProf;
        this.underGradUni = underGradUni;
    }

    /**
     * this method prints out student's information
     */
    public void displayStudentInformation(){
        super.displayInfo();
        System.out.println("Number of courses: 32");
        System.out.println("Guiding professor name: " + guiProf);
        System.out.println("Undergraduate university: " + underGradUni);
    }

    /**
     * getter method for the number of courses
     * @return
     */
    public int getCourses() {
        return courses;
    }

    /**
     * getter method for guiding professor's name
     * @return
     */
    public String getGuiProf() {
        return guiProf;
    }

    /**
     * setter method for guiding professor's name
     * @param guiProf
     */
    public void setGuiProf(String guiProf) {
        this.guiProf = guiProf;
    }

    /**
     * getter method for the name of the student's undergrad university
     * @return
     */
    public String getUnderGradUni() {
        return underGradUni;
    }

    /**
     * setter method for the name of the student's undergrad university
     * @param underGradUni
     */
    public void setUnderGradUni(String underGradUni) {
        this.underGradUni = underGradUni;
    }
}
