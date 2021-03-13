import java.io.IOException;

/**
 * This class is used to store the player prompts for the trivia game. Also, can
 * be used to clear the previous entries in the terminal window to make player
 * screens look cleaner.
 * 
 * Written by Kevin Chung for CS143 Group Project. Team Halt and Catch Fire.
 */

public class PromptReader {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";
    private static final String TEXT_YELLOW = "\u001B[33m";
    private static final String TEXT_BLUE = "\u001B[34m";

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
        String youWin = "\n" + TEXT_GREEN;
        youWin += "░█░█░█▀█░█░█░░░█░█░▀█▀░█▀█░█\n";
        youWin += "░░█░░█░█░█░█░░░█▄█░░█░░█░█░▀\n";
        youWin += "░░▀░░▀▀▀░▀▀▀░░░▀░▀░▀▀▀░▀░▀░▀\n";
        youWin += TEXT_RESET;
        System.out.println(youWin);
        triviaBye();
    }

    public void gameOverSplash() {
        String gameOver = "\n" + TEXT_RED;
        gameOver += "░█▀▀░█▀█░█▄█░█▀▀░░░█▀█░█░█░█▀▀░█▀▄\n";
        gameOver += "░█░█░█▀█░█░█░█▀▀░░░█░█░▀▄▀░█▀▀░█▀▄\n";
        gameOver += "░▀▀▀░▀░▀░▀░▀░▀▀▀░░░▀▀▀░░▀░░▀▀▀░▀░▀\n";
        gameOver += TEXT_RESET;
        System.out.println(gameOver);
        triviaBye();
    }

    public void exitGame() {
        clearScreen();
        System.out.println("Program terminated. We hope you will play at another time.");
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (System.getProperty("os.name").contains("Linux")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    private void playPrompt() {
        String playPrompt = TEXT_BLUE;
        playPrompt += "\nAre you ready to proceed?";
        playPrompt += "\t(1)YES or (2)NO";
        playPrompt += "\nEnter number selection: " + TEXT_RESET;
        System.out.println(playPrompt);
    }

    private void gameOverview() {
        String gameOverview = "\n" + TEXT_BLUE;
        gameOverview += "\tGame Overview: \n" + TEXT_RESET;
        gameOverview += "\tThe objective of this trivia game is to earn enough money to advance to the next rounds.\n";
        gameOverview += "\tThere are 3 rounds to play and each round will require an increasing amount of money to advance.\n";
        gameOverview += "\tEarned money will be recorded with the player's bank account.\n";
        gameOverview += "\tAfter the amount is met, the round will end and the next round begins.\n";
        gameOverview += "\tIf the player does not reach the required amount to advance, then the player loses and the game ends.";
        System.out.println(gameOverview);
    }

    private void triviaRules() {
        String triviaRules = "\n" + TEXT_BLUE;
        triviaRules += "\tTrivia Selection: \n" + TEXT_RESET;
        triviaRules += "\tEach question is separated by the category and prize money amount. \n";
        triviaRules += "\tDifficult questions are worth more money. Questions are based on 5th grade subjects and interest.\n";
        triviaRules += "\tTo select a question, \n";
        // TODO: (Caleb will need to describe how questions are selected from the
        // GameBoard).
        triviaRules += "\tAfter a question is selected, the player will have 15 seconds to answer the question.";
        // TODO: (Nicole may need to adjust the question timer if needed).
        System.out.println(triviaRules);
    }

    private void bankAccountRules() {
        String bankRules = "\n" + TEXT_BLUE;
        bankRules += "\tBank Account: \n" + TEXT_RESET;
        bankRules += "\tCorrect responses to questions will add the prize amount to the player's bank account.\n";
        bankRules += "\tIncorrect responses to questions will deduct the prize amount from the player's bank account.\n";
        bankRules += "\tNegative values are permitted.\n";
        // TODO: (Herrera will need to determine the round limits for each round).
        bankRules += "\t\tRound 1: $1000\n";
        bankRules += "\t\tRound 2: $10000";
        System.out.println(bankRules);
    }

    private void powerUpRules() {
        String powerRules = "\n" + TEXT_BLUE;
        powerRules += "\tPower-ups: \n" + TEXT_RESET;
        powerRules += "\tPlayers can earn question streaks after answering consecutive questions correctly.\n";
        powerRules += "\tThese power-ups are persistent through each round.";
        // TODO: (Zhengqi will need to determine what kind of power-ups he wants to
        // implement).
        System.out.println(powerRules);
    }

    private void triviaBye() {
        String closing = "Thank you for playing! We hope that you will play our game again.";
        System.out.println(closing);
    }

    private void haltCatchFireSplash() {
        String hcf = "\n" + TEXT_RED;
        hcf += "██   ██  █████  ██   ████████      ██████  █████  ████████  ██████ ██   ██     ███████ ██ ██████  ███████ \n";
        hcf += "██   ██ ██   ██ ██      ██        ██      ██   ██    ██    ██      ██   ██     ██      ██ ██   ██ ██      \n";
        hcf += "███████ ███████ ██      ██        ██      ███████    ██    ██      ███████     █████   ██ ██████  █████   \n";
        hcf += "██   ██ ██   ██ ██      ██        ██      ██   ██    ██    ██      ██   ██     ██      ██ ██   ██ ██      \n";
        hcf += "██   ██ ██   ██ ███████ ██         ██████ ██   ██    ██     ██████ ██   ██     ██      ██ ██   ██ ███████ \n";
        hcf += "=========================================================================================================";
        hcf += TEXT_RESET;
        System.out.println(hcf);
        teamShoutOut();
    }

    private void teamShoutOut() {
        String spacer = "\t\t"; // " "
        String names = "\n" + TEXT_YELLOW;
        names += "Caleb Churness" + spacer;
        names += "Kevin Chung" + spacer;
        names += "Nicole Gouhin" + spacer;
        names += "Herrera Wray" + spacer;
        names += "Zhengqi Yang" + spacer;
        names += TEXT_RESET;
        System.out.print(names + "\n");
    }

    private void instructSplash() {
        String instructSplash = "\n" + TEXT_YELLOW;
        instructSplash += "░▀█▀░█▀█░█▀▀░▀█▀░█▀▄░█░█░█▀▀░▀█▀░▀█▀░█▀█░█▀█░█▀▀\n";
        instructSplash += "░░█░░█░█░▀▀█░░█░░█▀▄░█░█░█░░░░█░░░█░░█░█░█░█░▀▀█\n";
        instructSplash += "░▀▀▀░▀░▀░▀▀▀░░▀░░▀░▀░▀▀▀░▀▀▀░░▀░░▀▀▀░▀▀▀░▀░▀░▀▀▀";
        instructSplash += TEXT_RESET;
        System.out.println(instructSplash);
    }
}