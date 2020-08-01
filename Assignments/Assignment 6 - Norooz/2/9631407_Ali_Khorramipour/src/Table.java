/**
 * this class represents the table used for this game
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Table {
    private char[][] status;

    public Table() {
        status = new char[10][10];
    }

    public void print() {
        System.out.print("  | ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");

        }
        System.out.println();
        System.out.print("-------------------------------------------\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 10; j++) {
                System.out.print(' ' + " | ");
            }
            System.out.println();
            System.out.print("-------------------------------------------\n");
        }
    }

    public void clearScreen(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
