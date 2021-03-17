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
        // May need to change the path to the "trivia.csv"; check your own computer.
        textFile = new File("trivia.csv");
        // Instantiate player bank account: Starting: $0 || Round 1: $1000 || Round 2: $3000 || Losing: -$1200
        BankAccount bank = new BankAccount(0, 1000, 4000, -1200);
        QuestionList game = new QuestionList(textFile);
        PromptReader prompter = new PromptReader();
        GameBoardConstructor gc = new GameBoardConstructor(2, game);
        GameBoard newGameboard = gc.getGameBoard(0);
        GameSound.loopMusic("gametrack.mid"); // Comment out line 26 and line 191 to cancel music

        Scanner readThis = new Scanner(System.in);
        int player;
        int round = -1;
        int roundMoney = -1;
        boolean playGame = false; // For internal game loop; flagged true when player prompts are registered.
        boolean program = true; // For overall program, will continue running until the beginning prompts ends.

        prompter.clearScreen();
        prompter.triviaWelcome();

        while (program) {
            if (readThis.hasNextInt()) {
                player = readThis.nextInt();
                if (checkInput(player, 0, 3)) {
                    readThis.nextLine();
                    System.out.print("Invalid input, please enter a whole number of either 1 or 2: ");
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
                            readThis.nextLine();
                            System.out.print("Invalid input, please enter a whole number of either 1 or 2: ");
                        } else if (player == 2) {
                            prompter.exitGame();
                            program = false;
                        } else if (player == 1) {
                            round = 1;
                            playGame = true;
                            program = false;

                            String questionAnswerResponse = "";
                            while (playGame && !newGameboard.allQuestionsAsked()) { // Actual game code!

                                // Game round conditions, check bank money, round information
                                if (newGameboard.allQuestionsAsked() || bank.getMoney() <= bank.getLowCeil()) {
                                    prompter.clearScreen();
                                    if (newGameboard.allQuestionsAsked()) {
                                        System.out.println("No more questions are availiable. You lose.");
                                    } else {
                                        System.out.println("Losing amount: $" + bank.getMoney());
                                        System.out.println("Your money is too low to continue.");
                                        System.out.println("Better luck next time.");
                                    }
                                    prompter.gameOverSplash();
                                    playGame = false;
                                    break;

                                } else if (!bank.enoughMoney(bank.getMoney(), bank.getRoundOne()) && round == 1) {
                                    roundMoney = bank.getRoundOne();

                                } else if (bank.enoughMoney(bank.getMoney(), bank.getRoundOne()) && round == 1) {
                                    // Second round, new GameBoard questions
                                    newGameboard = gc.getGameBoard(1);
                                    roundMoney = bank.getRoundTwo();
                                    round = 2;
                                } else if (bank.enoughMoney(bank.getMoney(), bank.getRoundTwo())) {
                                    // Player has won the game by making it to the end
                                    prompter.clearScreen();
                                    System.out.println("Winning amount: $" + bank.getMoney());
                                    prompter.winSplash();
                                    playGame = false;
                                    break;
                                }

                                prompter.clearScreen();

                                if (!questionAnswerResponse.equalsIgnoreCase("")) {
                                    System.out.println(questionAnswerResponse);
                                    questionAnswerResponse = "";
                                }

                                System.out.print(newGameboard);
                                prompter.gameInfo(bank.getMoney(), roundMoney);

                                int category = -1;
                                int question = -1;
                                // While the question - category input is invalid
                                while (!(0 <= category && category < GameBoard.getSize())
                                        || !(0 <= question && question < GameBoard.Category.size)) {

                                    readThis.nextLine();

                                    // Print out category options
                                    for (int i = 0; i < GameBoard.getSize(); i++) {
                                        System.out.println("(" + i + ") " + newGameboard.getCategory(i).getCategory());
                                    }
                                    System.out.print("\nSelect a Category: ");

                                    if (readThis.hasNextInt()) {
                                        int cat = readThis.nextInt();
                                        if (cat >= 0 && cat < GameBoard.getSize()) {
                                            prompter.questionSelectOptions();
                                            if (readThis.hasNextInt()) {
                                                int q = readThis.nextInt();
                                                if (q >= 0 && q < GameBoard.Category.size) {
                                                    if (newGameboard.hasBeenAsked(cat, q)) {
                                                        System.out.println("That question has already been asked!\n");
                                                    } else {
                                                        category = cat;
                                                        question = q;
                                                    }
                                                } else {
                                                    System.out.println("Yo, that was invalid! Get it together man!\n");
                                                }
                                            } else {
                                                System.out.println("Yo, that was invalid! Get it together man!\n");
                                            }
                                        } else {
                                            System.out.println("Yo, that was invalid! Get it together man!\n");
                                        }
                                    } else {
                                        System.out.println("Yo, that was invalid! Get it together man!\n");
                                    }
                                }
                                // bank adds/deduct prize money
                                bank.updatePrizeMoney(newGameboard.askQuestion(category, question));

                                String stillLost = "!";
                                String wrongOrRight = "";
                                boolean ranOutOfTime = newGameboard.getCategory(category).getQuestion(question)
                                        .getTimeRanOut();
                                int playerAnswer = newGameboard.getCategory(category).getQuestion(question)
                                        .getPlayerResponse();
                                int answer = newGameboard.getCategory(category).getQuestion(question).getAnswer();

                                if (playerAnswer == answer) {
                                    wrongOrRight = "right";
                                } else {
                                    wrongOrRight = "wrong";
                                }

                                if (playerAnswer == answer && ranOutOfTime) {
                                    stillLost = ", but you still lost money because you were slow!";
                                }

                                // This is a mess but it sets it's response to how you answered the last
                                // question
                                questionAnswerResponse = "You were " + wrongOrRight + "! The correct answer was "
                                        + newGameboard.getCategory(category).getQuestion(question)
                                                .getChoices()[newGameboard.getCategory(category).getQuestion(question)
                                                        .getAnswer()]
                                        + stillLost;

                            }
                        } else {
                            readThis.nextLine();
                            System.out.print(
                                    "Invalid input, please enter the integer corresponding to the previous prompt: ");
                        }
                    }
                } else {
                    readThis.nextLine();
                    System.out.print("Invalid input, please enter the integer corresponding to the previous prompt: ");
                }
            }
        }
        // Comment out line 26 and line 191 to cancel music
        GameSound.midiPlayer.close(); 
        readThis.close();
    }

    public static boolean checkInput(int input, int min, int max) {
        return (input <= min || input >= max);
    }
}