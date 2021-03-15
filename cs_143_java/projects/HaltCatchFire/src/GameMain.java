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
        // Instantiate player bank account: Starting: $0 || Round 1: $900 || Round 2: $1400;
        BankAccount bank = new BankAccount(0, 900, 1400);
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
                            
                            String questionAnswerResponse = "";
                            while (playGame && !newGameboard.allQuestionsAsked()) { // Actual game code!

                                if (!bank.enoughMoney(bank.getMoney(), bank.getRoundOne())) { // First round
                                    prompter.clearScreen();
                                    
                                    if(!questionAnswerResponse.equalsIgnoreCase("")) {
                                    	System.out.println(questionAnswerResponse);
                                    	questionAnswerResponse = "";
                                    }
                                    
                                    System.out.print(newGameboard);
                                    prompter.gameInfo(bank.getMoney(), bank.getRoundOne());

                                    
									int category = -1;
									int question = -1;
									// While the question - category input is invalid
									while (!(0 <= category && category < GameBoard.getSize())
											|| !(0 <= question && question < GameBoard.Category.size)) {
										
										readThis.nextLine();
										
										System.out.println();
										// Print out category options
										for (int i = 0; i < GameBoard.getSize(); i++) {
											System.out.println("(" + i + ") " + newGameboard.getCategory(i).getCategory());
										}
										System.out.print("Select a Category: ");
										// If hasNextInt
										if (readThis.hasNextInt()) {
											int cat = readThis.nextInt();
											if (cat >= 0 && cat < GameBoard.getSize()) {
												System.out.println();
												// I didn't feel like doing anything smart to display question values
												System.out.println("(0) $100");
												System.out.println("(1) $200");
												System.out.println("(2) $300");
												System.out.println("(3) $400");
												System.out.println("(4) $500");

												System.out.print("Select a Question: ");
												if (readThis.hasNextInt()) {
													int q = readThis.nextInt();
													if (q >= 0 && q < GameBoard.Category.size) {
														if(newGameboard.hasBeenAsked(cat, q)) {
															System.out.println("That question has already been asked!");
														} else {
															category = cat;
															question = q;
														}
													} else {
														System.out.println("Yo, that was invalid! Get it together man!");
													}
												} else {
													System.out.println("Yo, that was invalid! Get it together man!");
												}
											} else {
												System.out.println("Yo, that was invalid! Get it together man!");
											}
										} else {
											System.out.println("Yo, that was invalid! Get it together man!");
										}
									}

									// int category = readThis.nextInt();
									// int question = readThis.nextInt();
									// bank adds/deduct prize money
									bank.updatePrizeMoney(newGameboard.askQuestion(category, question));
									
									String stillLost = "!";
                                    String wrongOrRight = "";
                                    boolean ranOutOfTime = newGameboard.getCategory(category).getQuestion(question).getTimeRanOut();
                                    int playerAnswer = newGameboard.getCategory(category).getQuestion(question).getPlayerResponse();
                                    int answer = newGameboard.getCategory(category).getQuestion(question).getAnswer();
                                    
                                    if(playerAnswer == answer) {
                                    	wrongOrRight = "right";
                                    } else {
                                    	wrongOrRight = "wrong";
                                    }
                                    
                                    if(playerAnswer == answer && ranOutOfTime) {
                                    	stillLost = ", but you still lost money because you were slow!";
                                    }
                                    
                                    // This is a mess but it sets it's response to how you answered the last question
                                    questionAnswerResponse = "You were " + wrongOrRight + "! The correct answer was " 
                                    		+ newGameboard.getCategory(category).getQuestion(question).getChoices()[newGameboard.getCategory(category).getQuestion(question).getAnswer()]
                                    		+ stillLost;
                                    
                                } else if (!bank.enoughMoney(bank.getMoney(), bank.getRoundTwo())) {

                                    newGameboard = gc.getGameBoard(1); // Second round, new GameBoard questions
                                    prompter.clearScreen();
                                    System.out.print(newGameboard);
                                    prompter.gameInfo(bank.getMoney(), bank.getRoundTwo());

                                    int category = -1;
									int question = -1;
									// While the question - category input is invalid
									while (!(0 <= category && category < GameBoard.getSize())
											|| !(0 <= question && question < GameBoard.Category.size)) {
										
										readThis.nextLine();
										
										System.out.println();
										// Print out category options
										for (int i = 0; i < GameBoard.getSize(); i++) {
											System.out.println("(" + i + ") " + newGameboard.getCategory(i).getCategory());
										}
										System.out.print("Select a Category: ");
										// If hasNextInt
										if (readThis.hasNextInt()) {
											int cat = readThis.nextInt();
											if (cat >= 0 && cat < GameBoard.getSize()) {
												System.out.println();
												// I didn't feel like doing anything smart to display question values
												System.out.println("(0) $100");
												System.out.println("(1) $200");
												System.out.println("(2) $300");
												System.out.println("(3) $400");
												System.out.println("(4) $500");

												System.out.print("Select a Question: ");
												if (readThis.hasNextInt()) {
													int q = readThis.nextInt();
													if (q >= 0 && q < GameBoard.Category.size) {
														if(newGameboard.hasBeenAsked(cat, q)) {
															System.out.println("That question has already been asked!");
														} else {
															category = cat;
															question = q;
														}
													} else {
														System.out.println("Yo, that was invalid! Get it together man!");
													}
												} else {
													System.out.println("Yo, that was invalid! Get it together man!");
												}
											} else {
												System.out.println("Yo, that was invalid! Get it together man!");
											}
										} else {
											System.out.println("Yo, that was invalid! Get it together man!");
										}
									}

									// int category = readThis.nextInt();
									// int question = readThis.nextInt();
									// bank adds/deduct prize money
									bank.updatePrizeMoney(newGameboard.askQuestion(category, question));
									
									String stillLost = "!";
                                    String wrongOrRight = "";
                                    boolean ranOutOfTime = newGameboard.getCategory(category).getQuestion(question).getTimeRanOut();
                                    int playerAnswer = newGameboard.getCategory(category).getQuestion(question).getPlayerResponse();
                                    int answer = newGameboard.getCategory(category).getQuestion(question).getAnswer();
                                    
                                    if(playerAnswer == answer) {
                                    	wrongOrRight = "right";
                                    } else {
                                    	wrongOrRight = "wrong";
                                    }
                                    
                                    if(playerAnswer == answer && ranOutOfTime) {
                                    	stillLost = ", but you still lost money because you were slow!";
                                    }
                                    
                                    // This is a mess but it sets it's response to how you answered the last question
                                    questionAnswerResponse = "You were " + wrongOrRight + "! The correct answer was " 
                                    		+ newGameboard.getCategory(category).getQuestion(question).getChoices()[newGameboard.getCategory(category).getQuestion(question).getAnswer()]
                                    		+ stillLost;
                                    
                                } else { // Player has won the game by making it to the end
                                    prompter.clearScreen();
                                    prompter.winSplash();
                                    playGame = false;
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