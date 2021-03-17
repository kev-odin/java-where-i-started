public class BankAccount {
    private int money;
    private int roundOne;
    private int roundTwo;
    private int lowCeiling;

    public BankAccount(int initialAmount, int roundOne, int roundTwo, int lowCeiling) {
        this.money = initialAmount;
        this.roundOne = roundOne;
        this.roundTwo = roundTwo;
        this.lowCeiling = lowCeiling;
    }

    public boolean enoughMoney(int playerMoney, int roundAmount) {
        return (playerMoney >= roundAmount);
    }

    public void updatePrizeMoney(int prizeMoney) {
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

    public int getLowCeil() {
        return lowCeiling;
    }
}
