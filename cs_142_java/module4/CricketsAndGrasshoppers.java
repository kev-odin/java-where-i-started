import java.util.Scanner;
// Kevin Chung
public class CricketsAndGrasshoppers {

    public static void main(String[] args) {
        Scanner readThis = new Scanner(System.in);
        int max = 10;                               // given parameter
        int piecesPerPlayer = 0;
        int spacesInMiddle = 0;
        int player = 1;                     

        String[] playerName = new String[2];
        playerName[0] = "Crickets";
        playerName[1] = "Grasshoppers";

        String[] playerPrompt = new String[5];
        playerPrompt[0] = "Please enter the number of pieces for each player (1-10): ";
        playerPrompt[1] = "Please enter the number of spaces in the middle (1-9): ";
        playerPrompt[2] = ", please enter your move ";
        playerPrompt[3] = "That space does not contain a piece you can move! Please try again.";
        playerPrompt[4] = " win!";

        // Prompt user to make the game board array length
        piecesPerPlayer = promptNumberReadLine(readThis, playerPrompt[0], max);
        spacesInMiddle = promptNumberReadLine(readThis, playerPrompt[1], max - 1);
        max = spacesInMiddle + piecesPerPlayer * 2;

        int[] board = createBoard(piecesPerPlayer, spacesInMiddle);

        // Game has started playing, after the game board has been set up
        boolean playGame = true;
        while (playGame) {

            if (!canMove(board, player)) {
                if (player == 1) {
                    System.out.println(playerName[1] + playerPrompt[4]);

                } else {
                    System.out.println(playerName[0] + playerPrompt[4]);
                }
                playGame = false; // end game state, exit while loop
            }
            // Play the game! 
            if (playGame) { 
                System.out.println(boardToString(board));
                int playerInput = 1000;

                if (player == 1) {
                    boolean moveNext = true; // used to loop the player prompts until a valid input is entered
                    while (moveNext) {
                        playerInput = promptNumberReadLine(readThis, playerName[0] + playerPrompt[2] + "(1-" + max + "): ", max);
                        if (isMoveValid(board, player, playerInput)) {
                            move(board, player, playerInput);
                            moveNext = false;
                        } else {
                            System.out.println(playerPrompt[3]);
                        }
                    }
                    player++;

                } else {
                    boolean moveNext = true;
                    while (moveNext) {
                        playerInput = promptNumberReadLine(readThis, playerName[1] + playerPrompt[2] + "(1-" + max + "): ", max);
                        if (isMoveValid(board, player, playerInput)) {
                            move(board, player, playerInput);
                            moveNext = false;
                        } else {
                            System.out.println(playerPrompt[3]);
                        }
                    }
                    player--;
                }
            }
        }
    }

    public static int promptNumberReadLine(Scanner s, String prompt, int max) {

        int userInput = 0;
        String errorRange = "That was not a valid number! Please try again.";

        // Making sure that the user inputs are valid and within the the right range.
        while (true) {
            System.out.print(prompt);
            if (s.hasNextInt()) {
                userInput = s.nextInt();
                s.nextLine();
                if (userInput <= 0 || userInput > max) {
                    System.out.println(errorRange);
                } else {
                    return userInput;
                }
            } else {
                s.nextLine();
                System.out.println(errorRange);
            }
        }
    }

    public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle) {
        // create array length based on the player piece user input
        int[] gameBoard = new int[(piecesPerPlayer * 2) + spacesInMiddle];

        for (int i = 0; i < gameBoard.length; i++) {
            if (i < piecesPerPlayer) {
                gameBoard[i] = 1;
            } else if (i >= gameBoard.length - piecesPerPlayer) {
                gameBoard[i] = 2;
            }
        }
        return gameBoard;
    }

    public static String boardToString(int[] board) {
        String boardString = "";
        // Searching the board array for 0, 1, 2 and adding the corresponding letter
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 1) {
                boardString += "C";
            } else if (board[i] == 2) {
                boardString += "G";
            } else {
                boardString += ".";
            }
        }
        return boardString;
    }

    public static boolean isMoveValid(int[] board, int player, int position) {
        int i = position - 1;

        if (position <= board.length && position > 0) {
            // egde cases, end of the board
            if (player == 1) {
                if (position == board.length) {
                    return false;

                } else if (position == board.length - 1) { 
                    if (board[i + 1] == 0) {
                    } else {
                        return false;
                    }
                }
            }

            if (player == 2) {
                if (position == 1) {
                    return false;

                } else if (position == 2) {
                    if (board[1] == 0) {
                    } else {
                        return false;
                    }
                }
            }

            // Possible moves, based on the rule of the game, move 1 space ahead if empty
            // or if the space ahead is occupied by an enemy piece, then the space behind has to be empty.
            if (player == 1 && board[i] == 1) {
                if (board[i + 1] == 0 || board[i + 1] == 2 && board[i + 2] == 0) {
                    return true;
                }
            } else if (player == 2 && board[i] == 2) {
                if (board[i - 1] == 0 || board[i - 1] == 1 && board[i - 2] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canMove(int[] board, int player) {
        // Return true if the given player has any move they can make.

        for (int i = 0; i <= board.length - 1; i++) {
            int position = i + 1;
            if (isMoveValid(board, player, position)) {
                return true; // returns true after finding the first valid move
            }
        }
        return false;
    }

    public static boolean move(int[] board, int player, int position) {
        int i = position - 1; // adjust back to the index of the array

        if (!isMoveValid(board, player, position)) {
            return false;
        }

        if (player == 1 && board[i] == 1) {
            if (board[i + 1] == 2) { // grasshopper in front
                board[i] = 0;
                board[i + 2] = 1; // crickets jumped over a grasshopper

            } else if (board[i + 1] == 0) { // empty space in front
                board[i] = 0;
                board[i + 1] = 1; // crickets jumped to the next space
            }
        }

        if (player == 2 && board[i] == 2) {
            if (board[i - 1] == 1) { // cricket to the left
                board[i] = 0;
                board[i - 2] = 2; // grasshopper jumped over a cricket

            } else if (board[i - 1] == 0) { // empty space in front
                board[i] = 0;
                board[i - 1] = 2; // grasshopper jumped to the next space
            }
        }
        return true;
    }
}