import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else    return gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);
        int a, b;
        System.out.print("Enter the first number: ");
        a = inputStream.nextInt();
        System.out.print("Enter the second number: ");
        b = inputStream.nextInt();
        if(gcd(a, b) == 1)
            System.out.println("No common divisor except 1 !!");
        else
            System.out.println("The common divisor of entered numbers is: " + gcd(a, b));
    }
}
