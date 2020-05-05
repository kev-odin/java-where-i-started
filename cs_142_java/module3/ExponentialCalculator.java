
// Put your name here.
public class ExponentialCalculator {

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
		//Once you have the previous two methods coded, use the formula that approximates e^x. Namely,
		//e^x=1+x/1!+x^2/2!+...+x^n/n!
		
		
		return 1.0;
	}
	
	public static void main(String[] args) {
		//Here is some code to test your factorial and power methods:
		//System.out.println(factorial(4)); //should be 24
		//System.out.println(factorial(7)); // should be 5040
		//System.out.println(power(2,4)); // should be 16
		//System.out.println(power(1.5,3)); //should be 3.375
		
		
		//Compute two estimates for e^2.5, one using n=5 and the other n=10.
		//Use Math.exp(2.5) to compute the true value.
		//Compute the two true relative errors between your approximation and the true value.
		//Print out a sentence for each showing the approximation and the error.
		//Both errors should be less than 0.05 (i.e. 5%)

	}

}
