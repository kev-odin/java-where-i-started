public class BankAccount {
    private int money;
    private int roundOne;
    private int roundTwo;

    public BankAccount(int initialAmount, int roundOne, int roundTwo) {
        this.money = initialAmount;
        this.roundOne = roundOne;
        this.roundTwo = roundTwo;
    }

    public boolean enoughMoney(int playerMoney, int roundAmount) {
        return (playerMoney >= roundAmount);
    }

    public void setMoney(int prizeMoney) {
        this.money += prizeMoney;
    }

    public int getMoney() {
        return money;
    }

    public int getRoundOne() {
        return roundOne;
    }

    public int getRoundTwo() {
        return roundTwo;
    }
}
