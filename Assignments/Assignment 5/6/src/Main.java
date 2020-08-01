/**
 * main class for executing the program
 * @author Ali KhorramiPour
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        UndergraduateStudent ugs1 = new UndergraduateStudent("first 1", "last1", "id1",
                "ss1");
        ugs1.displayStudentInformation();
        ugs1.setId("id234");
        System.out.println(ugs1.getScholarship());

        System.out.println();

        GraduateStudent gs1 = new GraduateStudent("first2", "last2", "id2", "guiProf1",
                "underGradUni1");
        gs1.displayStudentInformation();
        gs1.setGuiProf("SH");
        gs1.setUnderGradUni("uni1337");

        System.out.println();

        gs1.displayStudentInformation();
    }
}
