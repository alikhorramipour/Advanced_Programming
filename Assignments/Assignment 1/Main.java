import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        String input = myInput.nextLine();
        int arraySize = (int)input.charAt(0)-48;
        arraySize *= 10;
        arraySize += (int)input.charAt(1)-48;
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            for(int j=1; j<=i; j++){
                array[i]+=j;
            }
        }
        for(int i=0; i<arraySize-1; i++){
            System.out.print(array[i] +", ");
        }
        System.out.print(array[arraySize-1]);
    }
}
