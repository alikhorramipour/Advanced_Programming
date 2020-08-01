import java.util.ArrayList;

/**
 * this class represents a matrix
 * @author Ali Khorramipour
 * @version 1.0
 */

public class Matrix {
    ArrayList<ArrayList<Integer>> table;

    public Matrix(ArrayList<ArrayList<Integer>> table) {
        this.table = table;
    }

    public void printMatrix(){
        for(int i = 0; i < table.size(); i++){
            for(int j = 0; j < table.get(i).size(); j++){
                System.out.print(table.get(i).get(j).intValue() + ", ");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix m1) {
        return null;
    }

    public Matrix multiply(Matrix m1){
        return null;
    }
}
