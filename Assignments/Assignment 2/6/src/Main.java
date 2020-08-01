public class Main {
    public static void main(String[] args){

        Rational firstnum = new Rational(2, 4);
        firstnum.printFloat();
        firstnum.printFraction();

        Rational secondnum = new Rational (3, 5);
        secondnum.printFloat();
        secondnum.printFraction();

        firstnum.mult(secondnum);
        firstnum.printFloat();
        firstnum.printFraction();

        firstnum.setNumerator(1);
        firstnum.setDenominator(2);

        firstnum.div(secondnum);
        firstnum.printFloat();
        firstnum.printFraction();

        firstnum.setNumerator(1);
        firstnum.setDenominator(2);

        firstnum.add(secondnum);
        firstnum.printFloat();
        firstnum.printFraction();

        firstnum.setNumerator(1);
        firstnum.setDenominator(2);

        firstnum.sub(secondnum);
        firstnum.printFloat();
        firstnum.printFraction();
    }
}
