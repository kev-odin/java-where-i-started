
/*
 * Takes in question list from main method to separate questions into two game boards
 * for however many rounds there may be
 * 
 * Stores gameboards as an array
 * 
 * gameboards are put together in constructer
 * and can be accessed using getGameBoard method
 * 
 * getGameBoard takes in an index and returns gameboard at that index
 */
public class GameBoardConstructor {
	// array of gameboards
	private GameBoard[] gameBoards;

	public GameBoardConstructor(int rounds, QuestionList qList) {
		// Set all gameboard categories to empty objects
		gameBoards = new GameBoard[rounds];
		for (int i = 0; i < gameBoards.length; i++) {
			gameBoards[i] = new GameBoard("Round " + (i + 1));
		}

		// for loop through # of gameboards
		for (int i = 0; i < rounds; i++) {
			// for loop through # of categories
			for (int j = 0; j < GameBoard.getSize(); j++) {
				// create new category
				gameBoards[i].addCategory(qList.triviaList.get((rounds * GameBoard.Category.size) * j).getCategory());
				// for loop through category
				for (int k = 0; k < GameBoard.Category.size; k++) {
					// create data that goes into question
					// create question
					int qIndex = (j * rounds * GameBoard.Category.size) + k + (i * GameBoard.Category.size);

					String qString = qList.triviaList.get(qIndex).getQuestionString();
					String[] qChoices = qList.triviaList.get(qIndex).getChoices();
					int answer = qList.triviaList.get(qIndex).getAnswer();
					int value = qList.triviaList.get(qIndex).getPrize();

					gameBoards[i].getCategory(j).add(qString, qChoices, answer, value);
				}
			}
		}
	}

	public GameBoard getGameBoard(int index) {
		return gameBoards[index];
	}
}
