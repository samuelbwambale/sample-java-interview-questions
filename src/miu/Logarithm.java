package miu;

/*
 * A method to calculate logarithm of a number. 
 * It takes double (x) and base (base)returns the logarithm to the base passed. Return type is a double
 */
public class Logarithm {

	public static void main(String[] args) {

		double result = log(2, 2);
		System.out.println(result);

	}

	static double log(double x, int base) {
		return (double) (Math.log(x) / Math.log(base));
	}

}
