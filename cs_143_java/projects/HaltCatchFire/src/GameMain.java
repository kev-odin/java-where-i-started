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
    private static boolean playGame = true;

    public static void main(String[] args) {
        textFile = new File("trivia.csv"); // May need to change the path to the "trivia.csv"; check your own computer.
        QuestionList game = new QuestionList(textFile);
        PromptReader prompter = new PromptReader();
        Scanner readThis = new Scanner(System.in);

        System.out.println(game);

        // prompter.triviaWelcome();
        // prompter.clearScreen();
        // prompter.instructPlayer();
        // prompter.gameOverSplash();
        // prompter.winSplash();

        // for (QuestionList.Question element : game.triviaList) {
        //     System.out.print(element + "\n");
        // }

        // prompter.triviaWelcome();

        // while (playGame) {
        //     String s = readThis.next();
        //     prompter.clearScreen();
        //     if (s.contains("y")) {
        //         prompter.winSplash();
        //         playGame = false;
        //     } else if (s.contains("n")) {
        //         prompter.gameOverSplash();
        //         playGame = false;
        //     } else {
        //         throw new InputMismatchException("You entered the wrong letter and now mustdie!");
        //     }
        // }
    }
}