import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMain {
    private static File textFile;
    public static void main(String[] args) {
        textFile = new File("trivia.csv"); // May need to change the path to where you have the "trivia.csv"; check your own computer.
        QuestionList library = new QuestionList(textFile);
        Scanner readThis = new Scanner(System.in);
        boolean playGame = true;

        triviaWelcome();

        while(playGame) {

            String s = readThis.next();
            if (s.contains("y")) {
                System.out.println("YO");
            } else if (s.contains("n")) {
                playGame = false;
            } else {
                throw new InputMismatchException("You entered the wrong letter and now must die!");
            }
        }
    }

    public static void triviaWelcome() {
        String welcome = "You are playing the latest and greatest trivia game of this generation!";
        String instruction = "To play this GOAT, please use the keyboard to make selections and follow the prompts.";
        String ready = "Are you ready to play? (Y/n)";
        System.out.println("\n" + welcome + "\n" + instruction + "\n" + ready + "\n");
    }
}
