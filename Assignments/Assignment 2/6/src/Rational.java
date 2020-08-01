/**
 * This class represents rational numbers and holds the methods for the arithmetic operations on them.
 * @author Ali
 * @version 1.0
 */
public class Rational {
    // instance variables
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * This method calculates the greatest common divisor of two numbers.
     * @param a: first entry
     * @param b: second entry
     * @return the "gcd" of the two numbers.
     */
    public int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    /**
     * Constructor for the object Rational.
     * @param numerator1
     * @param denominator1
     */
    public Rational(int numerator1, int denominator1){
        if(denominator1 == 0)
            System.out.println("Not defined !!");
        this.numerator = numerator1 / gcd(numerator1, denominator1);
        this.denominator = denominator1 / gcd(numerator1, denominator1);
    }

    public void add(Rational secondNumber){
        int lcd = (this.denominator * secondNumber.denominator) / gcd(this.denominator, secondNumber.denominator);
        this.numerator = (this.numerator * (lcd / this.denominator)) + (secondNumber.numerator * (lcd / secondNumber.denominator));
        this.denominator = lcd;
    }

    public void sub(Rational secondNumber){
        int lcd = (this.denominator * secondNumber.denominator) / gcd(this.denominator, secondNumber.denominator);
        this.numerator = (this.numerator * (lcd / this.denominator)) - (secondNumber.numerator * (lcd / secondNumber.denominator));
        this.denominator = lcd;
    }

    public void mult(Rational secondNumber){
        this.numerator *= secondNumber.numerator;
        this.denominator *= secondNumber.denominator;
        this.numerator = this.numerator / gcd(this.numerator, this.denominator);
        this.denominator = this.denominator / gcd(this.numerator, this.denominator);
    }

    public void div(Rational secondNumber){
        this.numerator *= secondNumber.denominator;
        this.denominator *= secondNumber.numerator;
        this.numerator = this.numerator / gcd(this.numerator, this.denominator);
        this.denominator = this.denominator / gcd(this.numerator, this.denominator);
    }

    public void printFraction(){
        System.out.println(numerator + "/" + denominator);
    }

    public void printFloat(){
        System.out.println((float)numerator/denominator);
    }
}
