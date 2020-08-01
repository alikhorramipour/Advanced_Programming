/**
 * @author Ali Khorramipour
 */
public class Main {
    public static void main(String[] args) {
        Plate plate1 = new Plate("9631407", "Ali", "Khorramipour");

        plate1.addFine("fine1");
        plate1.addFine("fine2");
        plate1.addFine("fine3");
        plate1.addFine("fine4");
        plate1.addFine("fine5");

        System.out.println(plate1.isValidity());

        plate1.forgiveFine("fine3");

        System.out.println(plate1.isValidity());
    }
}
