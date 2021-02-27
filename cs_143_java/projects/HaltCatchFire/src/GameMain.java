import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMain {
    private static File textFile;
    private static boolean playGame = true;

    public static void main(String[] args) {
        textFile = new File("trivia.csv"); // May need to change the path to the "trivia.csv"; check your own computer.
        QuestionList game = new QuestionList(textFile);
        PromptReader prompter = new PromptReader();
        Scanner readThis = new Scanner(System.in);

        System.out.println(prompter); 

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