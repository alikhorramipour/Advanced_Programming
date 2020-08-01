import java.util.ArrayList;

/**
 * This class represents an insurance company.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Insurance {
    private String name;

    ArrayList empList = new ArrayList<Employee>();

    public Insurance(String name) {
        this.name = name;
    }

    public void register(Employee emp1){
        if( (emp1.getFirstName() == emp1.getFirstNameOfSpouse()) && (emp1.getLastName() == emp1.getLastNameOfSpouse()) )
            System.out.println("Insurance record for employee " + emp1.getFirstName() + " " + emp1.getLastName() +
                    " cannot be registered!");
        else {
            empList.add(emp1);
            System.out.println("An insurance record for employee " + emp1.getFirstName() + " " + emp1.getLastName() +
                    " successfully registered by company " + this.name + ".");
        }
    }
}

