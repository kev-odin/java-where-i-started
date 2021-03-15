public class BankAccount {
    private int money;
    private int roundOne;
    private int roundTwo;
    private int incorrentAnswers;
    private int correctAnswer;

    public BankAccount(int initialAmount, int roundOne, int roundTwo) {
        this.money = initialAmount;
        this.roundOne = roundOne;
        this.roundTwo = roundTwo;
    }

    public boolean enoughMoney(int playerMoney, int roundAmount) {
        return (playerMoney >= roundAmount);
    }

    public void updatePrizeMoney(int prizeMoney) {
        this.money += prizeMoney;
    }

    public void resetMoney() {
        money = 0;
    }

    public int getMoney() {
        return money;
    }

    public int getRoundOne() {
        return roundOne;
    }

    // posssible lose conditions
    // --- too much negative money?
    // --- maybe too many wrong answers in a row?

    public boolean tooManyWrong (int wrong){
        incorrentAnswers = wrong;

        if(incorrentAnswers < 4 && incorrentAnswers >= 0 ){ // as long as the amount of incorrect answers isnt negative, or greater than 4 the player can continue.
            return true;
        }else if(correctAnswer > 1){ // for correct answers if the player gets a question correct during a losing streak and its still less than 4
            // this resets the losing streak to zero
            incorrentAnswers = 0;
            return true;
        }else

        return false; // the player will be given a loss if they reach 4 incorrect answers in a row
    }

public boolean lowMoney(){

        if(money <= -1200){
        return false;
        }else
        return true;
}

    public int getRoundTwo() {
        return roundTwo;
    }
}
