public class BankAccount {
    private String OwnerName;
    private String AccountID;
    private double balance;

    public BankAccount(String name, String id, double balance) {
        this.OwnerName = name;
        this.AccountID = id;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [AccountID=" + AccountID + ", OwnerName=" + OwnerName + ", balance=" + balance + "]";
    }
    
}