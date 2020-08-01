/**
 * This class runs the program.
 * @author Ali
 * @version 1.0
 */
public class Run {
    /**
     *
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {
        //defining three new students
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");

        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFirstName("Hamidreza");
        std3.print();

        Lab lab = new Lab(10, "Tuesday");

        lab.enrollStudent(std1);
        lab.enrollStudent(std2);
        lab.enrollStudent(std3);

        lab.calculateAvg();
        lab.print();
    }
}