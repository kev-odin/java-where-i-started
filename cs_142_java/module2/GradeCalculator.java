
public class GradeCalculator {

	public static void main(String[] args) {
		//you shouldn't need to put any new code in the main method. Just the other methods below.
		double score = weightedAverage(100,100,100,100,100,true); //Change these values to test your code.
		System.out.println("Your weighted average is: " + score);
		
		letterGrade(score); //This is just for the extra credit. Completely optional.
	}
	
	
	public static double weightedAverage(int quiz1, int quiz2, int quiz3, int exam1, int exam2, boolean hadGoodAttendance) {
		// Lowest quiz gets dropped. Each remaining quiz is worth 20%, so quizzes all together are 40%
		// If hadGoodAttendance is true, higher exam is worth 40% and lower exam is worth 20%. Otherwise each exam is worth 30%.
		
		return 0.0;
	}
	
	
	public static int minOfThree(int number1, int number2, int number3) {
		//returns the minimum of the three inputs.
	  	
		return 0;
	}
	
	
	public static void letterGrade(double score) {
		//prints a sentence describing a letter grade, based on the input score
		//this is optional, and is just for the extra credit.
		
	}

}
