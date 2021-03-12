import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard {

	// Category keeps track of questions using an array
	public class Category {

		public static final int size = 5;
		private String category;
		private Question[] questions;

		public Category(String cat) {
			category = cat;
			questions = new Question[size];
		}

		public boolean add(String qString, String[] qChoices, int answer, int value) {
			// add question to first null index and return true
			// if no null index, return false
			for (int i = 0; i < size; i++) {
				if (questions[i] == null) {
					questions[i] = new Question(qString, qChoices, answer, value);
					return true;
				}
			}
			return false;
		}

		// getters
		public String getCategory() {
			return category;
		}

		public Question getQuestion(int i) {
			return questions[i];
		}

		public String toString() {
			String s = "";

			s += "Category: " + category + "\n\n";

			for (Question q : questions) {
				s += q + "\n";
			}

			return s;
		}
	}

	// Question contains all the same information as questions in Question List
	// except: category and round
	public class Question {

		private String question;
		private String[] choices;
		private int answer;
		private int value;

		public Question(String qString, String[] qChoices, int answer, int value) {
			question = qString;
			choices = qChoices;
			this.answer = answer;
			this.value = value;
		}

		public String getQuestion() {
			return question;
		}

		public String[] getChoices() {
			return choices;
		}

		public int getAnswer() {
			return answer;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public String toString() {
			String s = "";

			s += "Question: " + question + "\n";
			s += "Choices: " + Arrays.toString(choices) + "\n";
			s += "Answer: " + answer + "\n";
			s += "Value: " + value + "\n";

			return s;
		}
	}

	private static final int size = 4;
	private Category[] cat;
	private String title;

	public GameBoard(String title) {
		this.title = title;
		cat = new Category[size];
	}

	/*
	 * Print out selected question Print out choices Use scanner to ask for input
	 * 
	 * ==================================================================== Ex:
	 * [Question] 0 [choice at index 0] 1 [Choice at index 1] 2 [Choice at index 2]
	 * 3 [Choice at index 3] Enter the number corresponding to your question:
	 * [player response]
	 * ====================================================================
	 * 
	 * If player response doesn't work say: Invalid answer, please select the
	 * question using the corresponding index: [player response]
	 * 
	 * If player answers correctly, return and remove value from question If player
	 * answers incorrectly, remove value from question and return 0
	 * 
	 * @param catIndex Category index
	 * 
	 * @param qIndex Question index
	 * 
	 * @return value Amount of winnings
	 */
	public int askQuestion(int catIndex, int qIndex) {

		Question q = cat[catIndex].getQuestion(qIndex);

		System.out.println(q.getQuestion());
		for (int i = 0; i < q.getChoices().length; i++) {
			System.out.println(i + ") " + q.getChoices()[i]);
		}

		int input = -1;

		System.out.print("Enter the number corresponding to your question: ");


			Timer timer = new Timer();
			TimerTask x = new TimerTask() {
				int start = 10;

				public void run() {
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("Seconds remaining to answer the question:");
					start = start - 1;
					for (int i = 1; i < 2; i++) {
						System.out.println(start);
						if (start <= 0) {
							System.out.println("Time's up!");
							System.out.println("The correct answer was: " + q.getChoices()[q.getAnswer()]);
							timer.cancel();
							break;
						}
					}
				}
			};
			timer.schedule(x,0, 1000);


		while (input < 0 || input >= q.getChoices().length) {

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			if (sc.hasNextInt()) {
				input = sc.nextInt();
				if (input < 0 || input >= q.getChoices().length) {
					System.out.print("Invalid input, please enter a number between 0 and " + (q.getChoices().length - 1));
				}
			} else {
				System.out.print("Invalid input, please enter the integer corresponding to your answer: ");
			}
		}

		int prize = q.getValue();
		q.setValue(0);

		if (input == q.getAnswer()) {
			System.out.println("Correct!");
			timer.cancel();
			return prize;
		}

		System.out.println("Incorrect! The correct answer was: " + q.getChoices()[q.getAnswer()]);
		timer.cancel();
		return prize * -1;

	}

	public boolean hasBeenAsked(int catIndex, int qIndex) {
		if (cat[catIndex].getQuestion(qIndex).getValue() == 0)
			return true;
		return false;
	}

	public boolean allQuestionsAsked() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < Category.size; j++) {
				if (!hasBeenAsked(i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	// Add methods -- returns true if category added
	public boolean addCategory(String name) {
		for (int i = 0; i < cat.length; i++) {
			if (cat[i] == null) {
				cat[i] = new Category(name);
				return true;
			}
		}

		return false;
	}

	// Turns all the game board information into a string
	public String toString() {
		// Create string board
		String board = "";

		/*
		 * Create colWidth variable and set it to largest category name use "-" and "+"
		 * to create borders
		 * 
		 * row separators should begin and end with + should contain (colWidth + 1) *
		 * size - 1
		 * 
		 * Game board title will be at the top of the trivia game enclosed in a large
		 * box
		 * 
		 * Use "|" to separate columns
		 * 
		 * when creating rows print row then row separator for loop will begin once
		 * categories are written
		 * 
		 * for this comment, stringSize will refer to whatever is being printed in a
		 * cell there should be colWidth - stringSize # of spaces in each cell If there
		 * are an odd number of spaces, #ofspaces/2 will be at start
		 * Math.ceil(#ofspaces/2) will be at end
		 * 
		 * \n will be used to print different rows in one string
		 */

		// ---------Determine-Important-Ints-------------------------------------------------------------------

		// Find largest colWidth
		int colWidth = 0;
		for (Category c : cat) {
			if (c.getCategory().length() > colWidth) {
				colWidth = c.getCategory().length();
			}
		}
		colWidth += 2;

		// excludes edges
		int gameBoardLength = size * (colWidth + 1) - 1;

		// --------This-Section-Creates-Game-Board-Components---------------------------------------------------

		// creates string for rowDivider
		String rowDivider = "";
		rowDivider += "+";
		for (int x = 0; x < gameBoardLength; x++) {
			rowDivider += "-";
		}
		rowDivider += "+\n";

		// creates string for title
		String titleText = this.title;
		String title = rowDivider;
		title += "|" + makeWithSpace(titleText, gameBoardLength) + "\n";
		title += rowDivider;

		// creates string for categories
		String categoryText = "|";
		for (int i = 0; i < size; i++) {
			categoryText += makeWithSpace(cat[i].getCategory(), colWidth);
		}
		categoryText += "\n" + rowDivider;

		// creates table portion
		String gameTable = "";
		// loop for number of rows
		for (int i = 0; i < Category.size; i++) {
			// fence post loop through cols
			gameTable += "|";
			for (int j = 0; j < GameBoard.size; j++) {
				if (cat[j].questions[i].value == 0) {
					gameTable += makeWithSpace("><", colWidth);
				} else {
					gameTable += makeWithSpace("$" + cat[j].questions[i].value, colWidth);
				}
			}
			gameTable += "\n" + rowDivider;
		}

		// ----------Combine-Components---------------------------------------------------------------------

		board += title;
		board += categoryText;
		board += gameTable;

		// return board
		return board;
	}

	public void printCategories() {
		String s = "";

		s += title + ":\n\n";
		for (Category c : cat) {
			s += "----------------------\n\n";
			s += c + "\n";
		}

		System.out.println(s);
	}

	/*
	 * Returns string that puts space before and after text depending on size
	 * 
	 * @param text to convert
	 * 
	 * @param size that is less than text.length
	 * 
	 * @param gameBoardLength
	 * 
	 * @return new text that combines text with spaces
	 */
	public String makeWithSpace(String text, int size) {

		// create newText to return at end
		String newText = "";

		// create numSpaces int which = size - text.length()
		int numSpaces = size - text.length();
		// create two for loops one before and after text is added
		// first loop goes for numSpaces/2 times
		// second loop goes for Math.ceil(numSpaces/2) times
		for (int i = 0; i < numSpaces / 2; i++) {
			newText += " ";
		}

		newText += text;

		for (int i = 0; i < (int) Math.ceil((double) numSpaces / 2); i++) {
			newText += " ";
		}
		// Place pipe character at end;
		newText += "|";
		// return newText
		return newText;
	}

	public static int getSize() {
		return size;
	}

	public Category getCategory(int index) {
		return cat[index];
	}

	public String getTitle() {
		return title;
	}
}

