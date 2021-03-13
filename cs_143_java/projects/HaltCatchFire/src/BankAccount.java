public class BankAccount {
    private int money;
    private int roundOne = 1000;
    private int roundTwo = 10000;

    public int bank() {
        return money;
    }

    public BankAccount(int initialAmount) {
        this.money = initialAmount;
    }

    public int addPrize(int prizeMoney) {
        money = money + prizeMoney;
        return money;
    }

    public boolean check(int currentMoney, int currentRound) {
        if (money >= roundOne) return true; 
        return false;
    }

}
