public class BankAccount {
    private String accountID;
    private String ownerName;
    private double accountBalance;

    public BankAccount(String accountID, String ownerName, double accountBalance) {
        this.accountID = accountID;
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        String s = "";
        s += "ID: " + accountID;
        s += "Name: " + ownerName;
        s += "Balance: " + accountBalance;
        return s;
    }
}