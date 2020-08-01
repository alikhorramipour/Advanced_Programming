/**
 * main class for executing a program
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        Bank b1 = new Bank();

        Account a1 = new SavingsAccount(1, 10);
        b1.addAccount(a1);
        a1.print();
        Account a2 = new SavingsAccount(2, 15);
        b1.addAccount(a2);
        a2.print();
        Account a3 = new CurrentAccount(3, 10);
        b1.addAccount(a3);
        a3.print();
        Account a4 = new CurrentAccount(4, 15);
        b1.addAccount(a4);
        a4.print();
        Account a5 = new CurrentAccount(5, 20);
        b1.addAccount(a5);
        a5.print();

        System.out.println();

        b1.update();

        a1.withdraw(50);
        a1.print();

        a2.withdraw(14);
        a2.print();

        a3.deposit(500);
        a3.print();

        a4.deposit(15);
        a4.print();

        a5.deposit(1000);
        a5.print();

        a4.withdraw(5);
        a4.print();
    }
}
