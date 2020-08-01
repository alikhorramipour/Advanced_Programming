/**
 * this class represents current account
 * @author Ali Khorramipour
 * @version 1.0
 */
public class CurrentAccount extends Account {
    // minimum amount of money to be in the account
    private long overdraftLimit;

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * the constructor for this class
     * @param num: account number
     * @param overdraftLimit: overdraft limit
     */
    public CurrentAccount(long num, long overdraftLimit) {
        super(num);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(long amount){
        if(amount > 0 && amount <= getBalance() && getBalance()-amount>overdraftLimit)
            super.withdraw(amount);
        else
            System.err.println("Invalid withdraw amount!");
    }

    public String toString(){
        return "Account Number #" + getAccountNumber() + "-->" + getBalance() + ", overdraft limit = " + overdraftLimit;
    }
}
