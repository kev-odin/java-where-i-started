import java.io.File;
import java.util.Scanner;

/**
 * This class is used to run the main trivia game.
 * 
 * List of classes: - QuestionList: scans a .csv and organizes that data into
 * Question objects. - PromptReader: provides game prompts that are not included
 * in GameBoard.
 * 
 * CS143 Group Project: Halt and Catch Fire - Cool Trivia Game
 */

public class GameMain {
    private static File textFile;

    public static void main(String[] args) {
        textFile = new File("trivia.csv"); // May need to change the path to the "trivia.csv"; check your own computer.
        BankAccount bank = new BankAccount(); // Instantiate player bank account
        QuestionList game = new QuestionList(textFile);
        PromptReader prompter = new PromptReader();
        GameBoard board = new GameBoard("Cool Trivia Game");
        GameBoardConstructor round1 = new GameBoardConstructor(1, game); // Hoping this is round 1 & round 2 respectively
        GameBoardConstructor round2 = new GameBoardConstructor(2, game);
        Scanner readThis = new Scanner(System.in);
        int player;
        boolean playGame = false; // For the internal game loop; flagged true when player prompts are registered
        boolean program = true; // For the overall program
        while (program) {
            prompter.triviaWelcome();
            if (readThis.hasNextInt()) {
                player = readThis.nextInt();
                if (player < 0 || player >= 3) {
                    System.out.print("Invalid input, please enter a whole number of either 1 or 2");
                } else if (player == 2) { // Exit the program.
                    prompter.exitGame();
                    program = false;
                } else if (player == 1) { // Selected to read the instructions for the trivia game
                    prompter.instructPlayer();
                    if (readThis.hasNextInt()) {
                        player = readThis.nextInt();
                        if (player < 0 || player >= 3) {
                            System.out.print("Invalid input, please enter a whole number of either 1 or 2");
                        } else if (player == 2) { // Exit the program.
                            prompter.exitGame();
                            program = false;
                        } else if (player == 1) { // Player has chosen to play the game!
                            playGame = true;
                            program = false;
                            while (playGame) { // Actual game code!
                                System.out.println("Please see this.");
                                playGame = false;
                                program = false;
                            }
                        }
                    }
                }
            } else {
                System.out.print("Invalid input, please enter the integer corresponding to your prompt: ");
            }
        }

        readThis.close();
    }
}