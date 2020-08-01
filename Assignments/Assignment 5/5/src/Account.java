/**
 * this class represents an account.
 * @author Ali KhorramiPour
 * @version 1.0
 */
public class Account {
    private long balance;
    private long accountNumber;

    /**
     * constructor for the class Account
     * @param num
     */
    public Account(long num){
        balance = 0;
        accountNumber = num;
    }

    /**
     * this method increases the balance
     */
    public void deposit(long amount){
        if(amount > 0)
            balance += amount;
        else
            System.err.println("Invalid deposit amount!");
    }

    /**
     * this method decreases the balance
     * @param amount
     */
    public void withdraw(long amount){
        if(amount > 0 && amount <= balance)
            balance -= amount;
        else
            System.err.println("Invalid withdraw amount!");
    }

    /**
     * getter method for balance
     * @return
     */
    public long getBalance() {
        return balance;
    }

    /**
     * getter method for account number
     * @return
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * overriding toString
     * this method prints out account information
     * @return
     */
    public String toString(){
        return "Account Number #" + accountNumber + "-->" + balance;
    }

    public final void print(){
        System.out.println( toString() );
    }
}
