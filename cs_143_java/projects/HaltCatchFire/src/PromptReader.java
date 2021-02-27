/**
 * This class is used to store the player prompts for the trivia game. 
 * Also, can be used to clear the previous entries in the terminal window
 * to make player screens to look cleaner.
 * 
 * Written by Kevin Chung for CS143 Group Project. Team Halt and Catch Fire.
 */

public class PromptReader {

    public void triviaWelcome() {
        clearScreen();
        haltCatchFireSplash();
        teamShoutOut();
        String triviaWelcome = "\n";
        triviaWelcome += "Welcome! You are about to play a trivia game we built for CS143.\n";
        triviaWelcome += "We wanted to share our hard work and hope you enjoy this program. \n";
        triviaWelcome += "Detailed player instructions and game rules are on the next screen. \n";
        triviaWelcome += "\nAre you ready to play? (Y/n)\n";
        System.out.print(triviaWelcome);
    }

    public void winSplash() {
        String youWin = "";
        youWin += "░█░█░█▀█░█░█░░░█░█░▀█▀░█▀█░█\n";
        youWin += "░░█░░█░█░█░█░░░█▄█░░█░░█░█░▀\n";
        youWin += "░░▀░░▀▀▀░▀▀▀░░░▀░▀░▀▀▀░▀░▀░▀\n";
        System.out.println(youWin);
        triviaBye();
    }

    public void gameOverSplash() {
        String gameOver = "";
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

    private void triviaBye() {
        String closing = "Thank you for playing! We hope that you will play with our game again.\n";
        System.out.println(closing);
    }

    private void haltCatchFireSplash() {
        String hcf = "\n";
        hcf += "██   ██  █████  ██   ████████      ██████  █████  ████████  ██████ ██   ██     ███████ ██ ██████  ███████ \n";
        hcf += "██   ██ ██   ██ ██      ██        ██      ██   ██    ██    ██      ██   ██     ██      ██ ██   ██ ██      \n";
        hcf += "███████ ███████ ██      ██        ██      ███████    ██    ██      ███████     █████   ██ ██████  █████   \n";
        hcf += "██   ██ ██   ██ ██      ██        ██      ██   ██    ██    ██      ██   ██     ██      ██ ██   ██ ██      \n";
        hcf += "██   ██ ██   ██ ███████ ██         ██████ ██   ██    ██     ██████ ██   ██     ██      ██ ██   ██ ███████ \n";
        hcf += "=========================================================================================================";
        System.out.println(hcf);
    }

    private void teamShoutOut() {
        String names = "";
        String spacer = "           ";
        names += "Caleb Churness" + spacer;
        names += "Kevin Chung" + spacer;
        names += "Herrera Wray" + spacer;
        names += "Nicole Gouhin" + spacer;
        names += "Zhengqi Yang" + spacer;
        System.out.print(names + "\n");
    }
}