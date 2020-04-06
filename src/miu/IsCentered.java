package miu;

/*
 * An array with an odd number of elements is said to be centered 
if all elements (except the middle one) are strictly greater 
than the value of the middle element. 
Note that only arrays with an odd number of elements have a middle element. 
Write a function that accepts an integer array and 
returns 1 if it is a centered array, otherwise it returns 0.
{ 3, 2, 1, 1, 4 } returns 0
{ 3, 2, 1, 5, 4 } returns 1
*/

public class IsCentered {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 4 };
		int output = isCentered(a);
		System.out.println(output);
	}

	static int isCentered(int[] a) {
		if (a.length == 1)
			return 1;
		if (a == null || a.length % 2 == 0) {
			System.out.println("goes thru here");
			return 0;
		}

		int midIndex = a.length / 2;
		int midNumber = a[midIndex];
		for (int i = 0; i < a.length; i++) {
			if (i != midIndex && midNumber >= a[i]) {
				return 0;
			}
		}
		return 1;
	}
}
