/**
 * @author Ali Khorramipour
 */
public class Main {
    public static void main(String[] args){
        Insurance ins1 = new Insurance("Iran");
        Insurance ins2 = new Insurance("Sina");

        Employee emp1 = new Employee("John", "Doe", 35, "John",
                "Doe");
        Employee emp2 = new Employee("Jane", "Doe", 34, "Hasan",
                "Hasani");
        Employee emp3 = new Employee("Ali", "Alavi", 666);

        ins1.register(emp1);
        ins1.register(emp2);
        ins2.register(emp3);
    }
}
