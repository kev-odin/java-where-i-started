
// Kevin Chung
public class ExponentialCalculator {

	public static void main(String[] args) {
		
		//Use Math.exp(2.5) to compute the true value.
		double trueValue = Math.exp(2.5);

		//Compute two estimates for e^2.5, one using n=5 and the other n=10.
		double testValueA = myExp(2.5, 5);
		double testValueB = myExp(2.5, 10);

		//Calculate the difference between the test value and true value, BEFORE taking the absolute value!
		double differenceBetweenA = testValueA - trueValue;
		double differenceBetweenB = testValueB - trueValue;

		//Compute the true relative errors between approximation and the true value. Both errors should be less than 0.05 (i.e. 5%)
		double trueRelativeErrorA = Math.abs(differenceBetweenA) / trueValue;
		double trueRelativeErrorB = Math.abs(differenceBetweenB) / trueValue;

		//Print out a sentence for each showing the approximation and the error.
		System.out.println("The true value of e^x is " + trueValue);
		System.out.println("The value of my approximation using n = 5 is : " + testValueA + " and the true relative error was " + trueRelativeErrorA + ".");
		System.out.println("The value of my approximation using n = 10 is : " + testValueB + " and the true relative error was " + trueRelativeErrorB + ".");
	}

	public static int factorial(int number) {
		int result = 1;
		//For loop to calculate the factorial, increment until the number is equal to the number.
		for(int i = 1; i <= number; i++) {
			result = result * i;
		}
		return result;
	}
	
	public static double power(double a,int b) {
		double result = 1.0;
		//For loop to compute a^b. Multiply a by itself b times.
		for(int i = 1; i <= b; i++) {
			result = result * a;
		}
		return result;
	}
	
	public static double myExp(double x, int n) {
		//Approximate the value of e^x. Namely using, e^x = 1 + x/1! + x^2/2! + ... + x^n/n!
		double result = 0.0;
		//For loop to calculate the summation of the series.
		for(int i = 0; i <= n; i++) {
			result = result + (power(x, i) / factorial (i));
		}
		return result;
	}
	
}
