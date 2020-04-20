// Kevin Chung

public class GradeCalculator {

	public static void main(String[] args) {
		//you shouldn't need to put any new code in the main method. Just the other methods below.
		double score = weightedAverage(100, 100, 100, 100, 100, true);
		System.out.println("Your weighted average is: " + score);

		// Prints corresponding letter grade with the score - extra credit
		letterGrade(score);
	}
	
	public static double weightedAverage(int quiz1, int quiz2, int quiz3, int exam1, int exam2, boolean hadGoodAttendance) {
		// Given score weights
		double poorAttendance = 0.30;
		double quizWeight = 0.20;
		double goodAttendanceHigher = 0.40;
		double goodAttendanceLower = 0.20;

		// Quiz weighted scores			
		double quizWeighted1 = quiz1 * quizWeight;
		double quizWeighted2 = quiz2 * quizWeight;
		double quizWeighted3 = quiz3 * quizWeight;

		double quizWeightedSum = quizWeighted1 + quizWeighted2 + quizWeighted3;
		
		// Lowest quiz dropped and casted to a double
		int droppedQuiz = minOfThree(quiz1, quiz2, quiz3);
		double droppedQuizWeighted = droppedQuiz * quizWeight;

		// Subtract the minimum of the three quizzes from the sum total
		double quizAdjustedTotal = quizWeightedSum - droppedQuizWeighted;

		// Poor attendance weighted average
		if (!hadGoodAttendance) {
			double poorAttendanceExam = (exam1 + exam2) * poorAttendance;
			double weightedScore = poorAttendanceExam + quizAdjustedTotal;
			return weightedScore;
		}
		// Good attendance weighted average
		if (hadGoodAttendance) {
			// If exam 1 is greater than exam 2
			if (exam1 >= exam2) {
				double examHigher = (exam1 * goodAttendanceHigher);
				double examLower = (exam2 * goodAttendanceLower);
				double goodAttendanceExam = examHigher + examLower;
				double weightedScore = goodAttendanceExam + quizAdjustedTotal;
				return weightedScore;
			}
			// If exam 2 is greater than exam 1
			else {
				double examHigher = (exam2 * goodAttendanceHigher);
				double examLower = (exam1 * goodAttendanceLower);
				double goodAttendanceExam = examHigher + examLower;
				double weightedScore = goodAttendanceExam + quizAdjustedTotal;
				return weightedScore;
			}
		}
		return 0.0; // Question about this return 0.0;
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
		if (score < 60.0 && score >= 0.0) {
			System.out.println("Your letter grade is a E");
		}
		if (score >= 60.0 && score < 70.0) {
			System.out.println("Your letter grade is a D");
		}
		if (score >= 70.0 && score < 80.0) {
			System.out.println("Your letter grade is a C");
		}
		if (score >= 80.0 && score < 90.0) {
			System.out.println("Your letter grade is a B");
		}
		if (score >= 90) {
			System.out.println("Your letter grade is a A");
		}
	}
}
