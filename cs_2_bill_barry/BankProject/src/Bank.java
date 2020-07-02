import java.util.ArrayList;

public class Bank {
    double interestRate;
    ArrayList<BankAccount> accounts;

    public Bank(double initialInterestRate) { //Breathe life into the object
        setInterestRate(initialInterestRate);
        accounts = new ArrayList<BankAccount>();
    }

    public BankAccount getAccount(int accountIndex) {
        return accounts.get(accountIndex);
    }
    
    public BankAccount getAccount(String accountID) {
        if (accountID == null || accountID.isEmpty()) {
            throw new IllegalArgumentException("Account ID must not be null or empty.");
        }

        for (BankAccount oneAccount : accounts) {
            if (oneAccount.getAccountID().equals(accountID)) {
                return oneAccount;
            }
        }
        return null; //Did not find an account
    }

    public void openAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account must not be null.");
        }
        //TODO: make sure that account doesn't exist
        accounts.add(account);
    }

    public boolean closeAccount(BankAccount account) {
        return accounts.remove(account);
    }

    public void setInterestRate(double newInterestRate) {
        if (newInterestRate < 0) {
            throw new IllegalArgumentException("The interest rate must not be negative.");
        }
        interestRate = newInterestRate;
    }

    public double getTotalBalance() {
        double totalBalance = 0.0;
        for (BankAccount oneAccount : accounts) {
            totalBalance += oneAccount.getAccountBalance();
        }
        return totalBalance;
    }

    public BankAccount[] getAccountsBelowAmount(double value) {
        ArrayList<BankAccount> belowAccounts = new ArrayList<BankAccount>();
        for (BankAccount acct : accounts) {
            if (acct.getAccountBalance() < value) {
                belowAccounts.add(acct);
            }
        }
        return belowAccounts.toArray(new BankAccount[0]); //ArrayLists
    }
}
