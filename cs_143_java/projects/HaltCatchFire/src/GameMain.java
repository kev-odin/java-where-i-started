import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is used to run the main trivia game.
 * 
 * List of classes: 
 * - QuestionList: scans a .csv and organizes that data into Question objects. 
 * - PromptReader: provides game prompts that are not included in GameBoard.
 * 
 * CS143 Group Project: Halt and Catch Fire - Cool Trivia Game
 */

public class GameMain {
    private static File textFile;

    public static void main(String[] args) {
        textFile = new File("trivia.csv"); // May need to change the path to the "trivia.csv"; check your own computer.
        QuestionList game = new QuestionList(textFile);
        PromptReader prompter = new PromptReader();
        Scanner readThis = new Scanner(System.in);
        int player;
        boolean playGame = false;
        boolean program = true;

        while (program) {
            try {
                prompter.clearScreen();
                prompter.triviaWelcome();
                player = readThis.nextInt();
                if (player == 2) {
                    prompter.exitGame();
                    program = false;
                } else if (player == 1) {
                    prompter.clearScreen();
                    prompter.instructPlayer();
                    player = readThis.nextInt();
                } else {
                    throw new InputMismatchException("That is not a valid choice.");
                }
                if (player == 2) {
                    prompter.exitGame();
                    program = false;
                } else if (player == 1) {
                    playGame = true;
                }
                while (playGame) {
                    System.out.println("You have chosen to play this game.");
                    playGame = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input.");
                prompter.exitGame();
                program = false;
            }
        }
        readThis.close();
    }
}