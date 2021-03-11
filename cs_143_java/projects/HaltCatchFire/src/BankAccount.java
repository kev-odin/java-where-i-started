import java.io.File;

public class BankAccount {
    private int money;
    private int roundOne = 1000;
    private int roundTwo = 2000;

    public int bank() {
        return money;
    }

    public BankAccount() {
        money = 0;
    }

    public int addPrize(int prizeMoney) {
        money = money + prizeMoney;
        return money;
    }

    public boolean Check() {
        if (money >= roundOne) {
            // means that the players money is either greater than or equal to the cut off
            // for round one
            return true; // player makes it to round 2
        } else
            return false;
    }

}
