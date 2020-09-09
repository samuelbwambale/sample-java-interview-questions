package miu;

/*
 * Write a function to reverse an integer using numeric operators 
 * and without using any arrays or other data structures.
*/

public class ReversedInteger {
	public static void main(String[] args) {
		int a = 101112;
		System.out.println(reversedInteger(a));
		System.out.println(reversedInteger2(a));
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

	static int reversedInteger2(int num) {
		String reverse = "";
		while (num > 0) {
			String digit = Integer.toString(num%10);
			reverse += digit;
			num = num / 10;
		}
		return Integer.parseInt(reverse);
	}
}
