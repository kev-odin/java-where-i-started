
public class Dice {
	// Dice is plural for die
	// A die is an object with a certain number of sides.
	// When you roll a die, a side comes up randomly.
	// Unbiased die: Each side has an equal probability of coming up.
	// We could use an inner class to model the die.
	public static class Die {
		// Only the Die and Dice classes can change sides for a Die
		private int sides; // Number of sides of the die
		private int smallestNumber; // Smallest number on the die
		private int faceUp; // Face up number in the range [smallest,smallest+sides)
		// When we create a die, it is always smallest face up.
		// Roll it to get to a (possibly) different face!
		
		/**
		 * Create a die with the given number of sides and
		 * smallestNumber is 1
		 * @param sides
		 */
		public Die(int sides) {
			// How do we plug the sides parameter
			// into the sides property/field?
			// Fill in a variable: Assignment: =
			// [left hand side] = [right hand side];
			// ^^ change this      ^^ to this
			this.sides = sides;
			this.smallestNumber = 1;
			this.faceUp = smallestNumber;
		}
		
		/**
		 * Create a die with the given number of sides and
		 * smallest number
		 * @param sides
		 * @param smallestNumber
		 */
		public Die(int sides, int smallestNumber) {
			this.sides = sides;
			this.smallestNumber = smallestNumber;
			this.faceUp = smallestNumber;
		}
		
		/**
		 * Cause the die to display a random face.
		 */
		public void roll() {
			this.faceUp = (int)(Math.random()*sides) + smallestNumber;
		}
		
		/**
		 * Get the value on the face-up face.
		 * @return
		 */
		public int getFace() {
			return faceUp;
		}
	}
	
	// Dice consists of multiple Die objects
	// Depending on the use of the dice, there could be a different
	// number of Die objects
	// Example: Craps: Two six sided dice
	// Example: D&D: Lots of different sets of dice
	// One example for D&D is "4d6 drop lowest" for character creation
	
	// Arrays are the way "built into Java" of dealing with
	// multiple things (primitive types or Objects)
	
	private Die[] dice; // By making it private, DiceRoller can't mess with the dice!

	/**
	 * Construct a sequence of "count" fair dice that all have "sides" sides.
	 * @param count How many dice?
	 * @param sides How many sides on each die?
	 */
	public Dice(int count, int sides) {
		// Set up the dice
		dice = new Die[count]; // Did this create any Die objects?
		// It doesn't. Arrays of objects are actually arrays of references.
		// The references start as null when we create the array.
		// (This is different for arrays of primitive types such as ints,
		// which always hold a value of the type, so they can't be null.)
		
		// Use a for loop to visit each location in the dice array
		// Plug a sides-sided die into each location
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Die(sides); // Create a die using constructor
		}
	}
	
	/**
	 * Causes the dice to enter a random orientation (a randomly chosen side for each die)
	 */
	public void roll() {
		// Visit each die and roll it!
		for (int i = 0; i < dice.length; i++) {
			dice[i].roll();
		}
	}
	
	/**
	 * Get the face of one of the dice
	 * @param die index of die (0 through count-1)
	 * @return
	 */
	public int getDieFace(int die) {
		return dice[die].getFace();
	}
	
	
	public static void main(String[] args) {
		// Create a 6 sided die
		Die die = new Die(6);
		// Check the die to see how many sides it has
		System.out.println(die.sides);
	}
}
