package miu;

/*
 * Write a function to reverse an integer using numeric operators 
 * and without using any arrays or other data structures.
*/

public class ReversedInteger {
	public static void main(String[] args) {
		int a = 101112;
		int output = reversedInteger(a);
		System.out.println(output);
	}

	static int reversedInteger(int num) {
		int reverse = 0;
		while (num != 0) {
			reverse = reverse * 10;
			reverse = reverse + num % 10;
			num = num / 10;
		}
		return reverse;
	}
}
