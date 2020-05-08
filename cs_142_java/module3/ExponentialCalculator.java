
// Kevin Chung

// Extra Credit
// The reason we start to get the error with a larger n is due to integer overflow.  
// The maximum factorial we can compute is 13! = 1932053504, the next value 14! = 1278945280. Which is incorrect because 14! > 13!
// This is due to the fact that we are exceeding the maximum range that is supported by the int data type. When we add each additional factorial value, we exceed the range after 13!
// To remedy this error we can use the long data type which will expand the range of the value that we want to store/calculate.

public class ExponentialCalculator {

	public static void main(String[] args) {
		
		//Use Math.exp(2.5) to compute the true value.
		double trueValue = Math.exp(2.5);

		//Compute two estimates for e^2.5, one using n=5 and the other n=10 with the myExp() method.
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

		// Here is some code to test your factorial and power methods:
		// System.out.println(factorial(4)); //should be 24
		// System.out.println(factorial(7)); // should be 5040
		// System.out.println(power(2,4)); // should be 16.0
		// System.out.println(power(1.5,3)); //should be 3.375
	}

	public static int factorial(int number) {
		int result = 1;
		//For loop to calculate the factorial, increment until i is equal to the number.
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
