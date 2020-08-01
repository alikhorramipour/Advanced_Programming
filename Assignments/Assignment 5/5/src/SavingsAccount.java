/**
 * this class represents a saving account
 * @author Ali Khorramipour
 * @version 1.0
 */
public class SavingsAccount extends Account {
    private long interestRate;

    /**
     * this method add to the account's balance according to the interest rate
     */
    public void putInterest(){
        super.deposit(interestRate);
    }

    /**
     * the constructor for this class
     * @param num
     * @param interestRate
     */
    public SavingsAccount(long num, long interestRate) {
        super(num);
        this.interestRate = interestRate;
    }

    public String toString(){
        return "Account Number #" + getAccountNumber() + "-->" + getBalance() + ", interest rate = " + interestRate;
    }
}
