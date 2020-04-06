package miu;

/*
 * SumFactor of an array is defined as the number of times that the sum of the array appear as an element of the array
 * Write a function that returns the sum factor of its array argument
*/

public class SumFactor {

	public static void main(String[] args) {
		int[] a = { 3, 0, 2, -5, 0 };
		int result = sumFactor(a);
		System.out.println("Result is " + result);
	}

	static int sumFactor(int[] a) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] == sum) {
				count += 1;
			}
		}
		return count;

	}
}
