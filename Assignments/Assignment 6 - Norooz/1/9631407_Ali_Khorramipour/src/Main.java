import java.util.ArrayList;
import java.util.Scanner;

/**
 * main class for executing the program
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // getting input from user
        Scanner input = new Scanner(System.in);

        // two sets of arraylists for storing two matrix
        ArrayList<ArrayList<Integer>> table1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> table2 = new ArrayList<>();

        System.out.println("Define the first matrix(X): ");
        ArrayList<Integer> tempRow = new ArrayList<>();
        String tempInp = input.nextLine();
        while(!(tempInp.isEmpty())){
            for(int i = 0; i < tempInp.length(); i++) {
                if( (47 < tempInp.charAt(i)) && (tempInp.charAt(i) < 58) ){
                    tempRow.add((int)tempInp.charAt(i) - 48);
                }
            }
            table1.add(tempRow);
            tempRow.removeAll();
            tempInp = input.nextLine();
        }

        System.out.println("Define the second matrix(Y): ");
        tempInp = input.nextLine();
        while(!(tempInp.isEmpty())){
            for(int i = 0; i < tempInp.length(); i++) {
                if( (47 < tempInp.charAt(i)) && (tempInp.charAt(i) < 58) ){
                    tempRow.add((int)tempInp.charAt(i) - 48);
                }
            }
            table2.add(tempRow);
            tempRow.clear();
            tempInp = input.nextLine();
        }

        System.out.println("Enter your polynomial expression: ");
        //String polyExp = input.nextLine();
        int firstMultplier = 2, secondMultplier = 5;

        /*
        if( (polyExp.charAt(0) == '(') || (polyExp.charAt(1) == '-') )
            firstMultplier = ((int)polyExp.charAt(1) - 48) * (-1);
        else
            firstMultplier = ((int)polyExp.charAt(1) - 48);

        if(polyExp.charAt(polyExp.length() - 2) == ')')
            secondMultplier = ((int)polyExp.charAt(polyExp.length() - 3) - 48) * (-1);
        else if(polyExp.charAt(polyExp.length() - 1) == '-')
            secondMultplier = ((int)polyExp.charAt(polyExp.length() - 2) - 48);
        firstMultplier = input.nextInt();
        System.out.println(firstMultplier);
        secondMultplier = input.nextInt();
        System.out.println(secondMultplier);
        */

        /*char func;
        for(int i = 2; i < polyExp.length(); i++){
            if((polyExp.charAt(i) == '+') || (polyExp.charAt(i) == '-') || (polyExp.charAt(i) == '*')){
                func = polyExp.charAt(i);
                break;
            }
        }

*/

        for(int i = 0; i < table1.size(); i++){
            for(int j = 0; j < table1.get(i).size(); j++){
                table1.get(i).set(j, table1.get(i).get(j).intValue() * firstMultplier);
            }
        }


        for(int i = 0; i < table2.size(); i++){
            for(int j = 0; j < table2.get(i).size(); j++){
                table2.get(i).set(j, table1.get(i).get(j).intValue() * secondMultplier);
            }
        }
        Matrix m1 = new Matrix(table1);
        m1.printMatrix();

        Matrix m2 = new Matrix(table2);




    }
}