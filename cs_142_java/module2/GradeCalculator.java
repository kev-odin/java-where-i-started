
public class GradeCalculator {

	public static void main(String[] args) {
		//you shouldn't need to put any new code in the main method. Just the other methods below.
		double score = weightedAverage(0,0,0,0,0,false); //Change these values to test your code.
		System.out.println("Your weighted average is: " + score);

		letterGrade(score); //This is just for the extra credit. Completely optional.
	}
	
	public static double weightedAverage(int quiz1, int quiz2, int quiz3, int exam1, int exam2, boolean hadGoodAttendance) {
		// Lowest quiz gets dropped. Each remaining quiz is worth 20%, so quizzes all together are 40%
		// If hadGoodAttendance is true, higher exam is worth 40% and lower exam is worth 20%. Otherwise each exam is worth 30%.
		double poorAttendanceAdjustment = 0.30;
		double quizWeighted = 0.40;
		double goodAttendanceHigher = 0.40;
		double goodAttendanceLower = 0.20;

		// Adds the sum of all quiz totals
		int quizSumTotal = quiz1 + quiz2 + quiz3;

		// Subtract the minimum of the three quizzes from the sum total, and multiply the weighted average to determine the quiz adjusted score
		int quizDroppedTotal = quizSumTotal - minOfThree(quiz1, quiz2, quiz3);
		double quizAdjusted = (double) (quizDroppedTotal * quizWeighted);
		System.out.println("Your quiz adjusted score is: " + quizAdjusted);

		// Poor attendance weighted average
		if (hadGoodAttendance != true) {
			double examScore = (double) (exam1 + exam2);
			double examScoreAdjusted = examScore * poorAttendanceAdjustment;
			System.out.println("Your exam adjusted score is: " + examScoreAdjusted);
			double scoreAdjusted = examScoreAdjusted + quizAdjusted;
		}
		// Good attendance weighted average
		if (hadGoodAttendance == true) {
			// If exam 1 is greater than exam 2
			if (exam1 >= exam2) {
				double examHigher = (double) (exam1 * goodAttendanceHigher);
				double examLower = (double) (exam2 * goodAttendanceLower);
				double examScoreAdjusted = examHigher + examLower;
				double scoreAdjusted = examScoreAdjusted + quizAdjusted;
			}
			// If exam 2 is greater than exam 1
			else {
				double examHigher = (double) (exam2 * goodAttendanceHigher);
				double examLower = (double) exam1 * goodAttendanceLower;
				double examScoreAdjusted = examHigher + examLower;
				double scoreAdjusted = examScoreAdjusted + quizAdjusted;
			}
		}
	return (double) 0.0;
	}
	
	public static int minOfThree(int number1, int number2, int number3) {
		//returns the minimum of the three inputs.
		  if (number1 <= number2 && number1 <= number3) {
			  return number1;
		  }
		  if (number2 <= number1 && number2 <= number3) {
			return number2;
		  }
		return number3;
	}
	
	public static void letterGrade(double score) {
		//prints a sentence describing a letter grade, based on the input score
		//this is optional, and is just for the extra credit.
		
	}

}
