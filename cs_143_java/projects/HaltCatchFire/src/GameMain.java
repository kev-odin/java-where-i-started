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
        BankAccount bank = new BankAccount(0, 1000, 10000); // Instantiate player bank account: Starting amount: $0, Round 1: $1000, Round 2: $10000;
        QuestionList game = new QuestionList(textFile);
        PromptReader prompter = new PromptReader();
        GameBoardConstructor gc = new GameBoardConstructor(2, game);
        GameBoard newGameboard = gc.getGameBoard(0);

        Scanner readThis = new Scanner(System.in);
        int player;
        boolean playGame = false; // For the internal game loop; flagged true when player prompts are registered.
        boolean program = true; // For the overall program, will continue running until the game ends.

        prompter.clearScreen();
        prompter.triviaWelcome();

        while (program) {
            if (readThis.hasNextInt()) {
                player = readThis.nextInt();
                if (checkInput(player, 0, 3)) {
                    System.out.print("Invalid input, please enter a whole number of either 1 or 2");
                } else if (player == 2) {
                    prompter.exitGame();
                    program = false;
                } else if (player == 1) {
                    prompter.clearScreen();
                    prompter.instructPlayer();
                    readThis.nextLine();
                    if (readThis.hasNextInt()) {
                        player = readThis.nextInt();
                        if (checkInput(player, 0, 3)) {
                            System.out.print("Invalid input, please enter a whole number of either 1 or 2");
                        } else if (player == 2) {
                            prompter.exitGame();
                            program = false;
                        } else if (player == 1) {
                            playGame = true;
                            program = false;

                            while (playGame && !newGameboard.allQuestionsAsked() && !bank.enoughMoney(bank.getMoney(), bank.getRoundOne())) { // Actual game code!
                                prompter.clearScreen();
                                System.out.print(newGameboard);
                                prompter.gameInfo(bank.getMoney(), bank.getRoundOne());

                                if (readThis.hasNextInt()) {
                                    int category = readThis.nextInt();
                                    int question = readThis.nextInt();
                                    bank.setMoney(newGameboard.askQuestion(category, question)); // bank adds/deduct prize money
                                } 
                                else {
                                    System.out.println("Invalid input, please enter a whole number.");
                                    System.out.print(newGameboard);
                                }
                            }
                        }
                    }
                }
            } else {
                readThis.nextLine();
                System.out.print("Invalid input, please enter the integer corresponding to the previous prompt: ");
            }
        }
        readThis.close();
    }

    public static boolean checkInput(int input, int min, int max) {
        return (input < min || input >= max);
    }
}