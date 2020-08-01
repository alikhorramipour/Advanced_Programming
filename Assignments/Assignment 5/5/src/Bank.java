import java.util.ArrayList;

/**
 * this class represents a bank
 * @author Ali Khorramipour
 * @version 1.0
 */

public class Bank {
    ArrayList <Account> accounts = new ArrayList<Account>();

    /**
     * this method adds an account to the array of the accounts
     * @param account
     */
    public void addAccount(Account account){
        accounts.add(account);
    }

    /**
     * this method updates the accounts
     */
    public void update(){
        for(Account account : accounts){
            if(account instanceof SavingsAccount){
                ((SavingsAccount) account).putInterest();
            }else if(account instanceof CurrentAccount){
                if(((CurrentAccount) account).getOverdraftLimit() > account.getBalance()){
                    System.out.println(account.toString());
                }
            }
        }
    }
}
