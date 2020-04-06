package miu;

/*
 * An array is rapidly increasing if each element (except the first one) 
is greater than twice the sum of all its preceding elements.
Write a method named isRapidlyIncreasing that returns 1 if its array argument is 
rapidly increasing. Otherwise it returns 0.
If you are programming in Java or C#, the function signature is int isRapidlyIncreasing(int[ ] a)

{1, 3, 9, 27}	returns 1	because 3 > 2*(1), 9 > 2*(1+3), 27 > 2*(1+3+9)
{1, 3, 200, 500}	returns 1	because 3 > 2*(1), 200 > 2*(1+3), 500 > 2*(1+3+200)
{1}	returns 1	because all arrays that have only one element are rapidly increasing by definition.
{1, 3, 9, 26}	returns 0	because 26 is not greater than 2*(1+3+9)
{1, 3, 7, 26}	returns 0	because 7 is not greater than 2*(1+3)
{1, 3, 8, 26}	returns 0	because 8 is not greater than 2*(1+3)

*/

public class IsRapidlyIncreasing {
	public static void main(String[] args) {
		int[] a = { 1, 3, 8, 26 };
		int result = isRapidlyIncreasing(a);
		System.out.println(result);

	}

	static int isRapidlyIncreasing(int[] a) {

		int prevSum = a[0];
		int result = 1;
		for (int i = 1; i <= a.length - 1; i++) {
			if (a[i] > 2 * prevSum) {
				result = 1;
			} else {
				result = 0;
				break;
			}
			prevSum += a[i];
		}

		return result;
	}

}
