/**
 * This class is used to store the player prompts for the trivia game. 
 * Also, can be used to clear the previous entries in the terminal window
 * to make player screens look cleaner.
 * 
 * Written by Kevin Chung for CS143 Group Project. Team Halt and Catch Fire.
 */

public class PromptReader {

    public void triviaWelcome() {
        haltCatchFireSplash();
        String triviaWelcome = "\n";
        triviaWelcome += "Welcome! You are about to play a trivia game we built for CS143.\n";
        triviaWelcome += "We wanted to share our hard work and hope you enjoy this program. \n";
        triviaWelcome += "Detailed player instructions and game rules are on the next screen. \n";
        System.out.print(triviaWelcome);
        playPrompt();
    }

    public void instructPlayer() {
        instructSplash();
        gameOverview();
        triviaRules();
        bankAccountRules();
        powerUpRules();
        playPrompt();
    }

    public void winSplash() {
        String youWin = "\n";
        youWin += "░█░█░█▀█░█░█░░░█░█░▀█▀░█▀█░█\n";
        youWin += "░░█░░█░█░█░█░░░█▄█░░█░░█░█░▀\n";
        youWin += "░░▀░░▀▀▀░▀▀▀░░░▀░▀░▀▀▀░▀░▀░▀\n";
        System.out.println(youWin);
        triviaBye();
    }

    public void gameOverSplash() {
        String gameOver = "\n";
        gameOver += "░█▀▀░█▀█░█▄█░█▀▀░░░█▀█░█░█░█▀▀░█▀▄\n";
        gameOver += "░█░█░█▀█░█░█░█▀▀░░░█░█░▀▄▀░█▀▀░█▀▄\n";
        gameOver += "░▀▀▀░▀░▀░▀░▀░▀▀▀░░░▀▀▀░░▀░░▀▀▀░▀░▀\n";
        System.out.println(gameOver);
        triviaBye();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    private void playPrompt() {
        String playPrompt = "\nAre you ready to proceed? (Y/n)";
        System.out.println(playPrompt);
    }
    
    private void gameOverview() {
        String gameOverview = "\n";
        gameOverview += "\tGame Overview: \n";
        gameOverview += "\tThe objective of this trivia game is to earn enough money to advance to the next rounds.\n";
        gameOverview += "\tThere are 3 rounds to play and each round will require an increasing amount of money to advance.\n";
        gameOverview += "\tEarned money will be recordedwith the player's bank account. After the amount is met, the round will end and the next round begins.\n";
        gameOverview += "\tIf the player does not reach the required amount to advance, then the player loses and the game ends.";
        System.out.println(gameOverview);
    }

    private void triviaRules() {
        String triviaRules = "\n";
        triviaRules += "\tTrivia Selection: \n";
        triviaRules += "\tEach question is separated by the category and prize money amount. \n";
        triviaRules += "\tDofficult questions are worth more money. Questions are based on 5th grade subjects and interest.\n";
        triviaRules += "\tTo select a question, \n";
        //TODO: (Caleb will need to describe how questions are selected from the GameBoard).
        triviaRules += "\tAfter a question is selected, the player will have 15 seconds to answer the question.";
        //TODO: (Nicole may need to adjust the question timer if needed).
        System.out.println(triviaRules);
    }

    private void bankAccountRules() {
        String bankRules = "\n";
        bankRules += "\tBank Account: \n";
        bankRules += "\tCorrect responses to questions will add the prize amount to the player's bank account.\n";
        bankRules += "\tIncorrect responses to questions will deduct the prize amount from the player's bank account. Negative values are permitted.\n";
        //TODO: (Herrera will need to determine the round limits for each round).
        bankRules += "\t\tRound 1: $1000\n";
        bankRules += "\t\tRound 2: $10000";
        System.out.println(bankRules);
    }

    private void powerUpRules() {
        String powerRules = "\n";
        powerRules += "\tPower-ups: \n";
        powerRules += "\tPlayers can earn question streaks after answering consecutive questions correctly.\n";
        powerRules += "\tThese power-ups are persistent through each round.";
       //TODO: (Zhengqi will need to determine what kind of power-ups he wants to implement).
        System.out.println(powerRules);
    }

    private void triviaBye() {
        String closing = "Thank you for playing! We hope that you will play our game again.";
        System.out.println(closing);
    }

    private void haltCatchFireSplash() {
        clearScreen();
        String hcf = "\n";
        hcf += "██   ██  █████  ██   ████████      ██████  █████  ████████  ██████ ██   ██     ███████ ██ ██████  ███████ \n";
        hcf += "██   ██ ██   ██ ██      ██        ██      ██   ██    ██    ██      ██   ██     ██      ██ ██   ██ ██      \n";
        hcf += "███████ ███████ ██      ██        ██      ███████    ██    ██      ███████     █████   ██ ██████  █████   \n";
        hcf += "██   ██ ██   ██ ██      ██        ██      ██   ██    ██    ██      ██   ██     ██      ██ ██   ██ ██      \n";
        hcf += "██   ██ ██   ██ ███████ ██         ██████ ██   ██    ██     ██████ ██   ██     ██      ██ ██   ██ ███████ \n";
        hcf += "=========================================================================================================";
        System.out.println(hcf);
        teamShoutOut();
    }

    private void teamShoutOut() {
        String names = "";
        String spacer = "           ";
        names += "Caleb Churness" + spacer;
        names += "Kevin Chung" + spacer;
        names += "Nicole Gouhin" + spacer;
        names += "Herrera Wray" + spacer;
        names += "Zhengqi Yang" + spacer;
        System.out.print(names + "\n");
    }

    private void instructSplash() {
        String instructSplash = "\n";
        instructSplash += "░▀█▀░█▀█░█▀▀░▀█▀░█▀▄░█░█░█▀▀░▀█▀░▀█▀░█▀█░█▀█░█▀▀\n";
        instructSplash += "░░█░░█░█░▀▀█░░█░░█▀▄░█░█░█░░░░█░░░█░░█░█░█░█░▀▀█\n";
        instructSplash += "░▀▀▀░▀░▀░▀▀▀░░▀░░▀░▀░▀▀▀░▀▀▀░░▀░░▀▀▀░▀▀▀░▀░▀░▀▀▀";
        System.out.println(instructSplash);
    }

    public String toString() {
        triviaWelcome();
        instructPlayer();
        winSplash();
        gameOverSplash();
        return "";
    }
}