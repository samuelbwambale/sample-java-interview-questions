package miu;

/*
 * A 123 array is an array that contains multiple repetitions of the values 1, 2, 3 
in that order. For example {1, 2, 3, 1, 2, 3, 1, 2, 3} is a 123 array 
but {1, 2, 3, 1, 2} is not. Write a function named is123Array which returns 1 
if its array argument is a 123 array, otherwise it returns 0.
If you are programming in Java or C#, the function prototype is int is123Array(int[ ] a)

{1, 2, 3, 3, 2, 1}	returns 0	elements a[3], a[4], a[5] are not 1, 2, 3
{0, 1, 2, 3, 1, 2, 3}	returns 0	elements a[0], a[1], a[2] are not 1, 2, 3
{1, 2, 3, 3, 2, 1, 1, 2, 3}	returns 0	elements a[3], a[4], a[5] are not 1, 2, 3
{1, 2, 3}	returns 1	 
{}	returns 0	must contain at least one 1, 2, 3 triad
*/

public class Is123Array {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1, 2, 3, };
		int result = is123Array(a);
		System.out.println(result);

	}

	static int is123Array(int[] a) {
		if (a.length < 3 || a.length % 3 != 0) {
			return 0;
		}

		if (a[0] != 1) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < a.length; i += 3) {
			if ((a[i] == 1) && (a[i + 1] == 2) && (a[i + 2] == 3)) {
				result = 1;
			}

			else {
				result = 0;
				break;
			}

		}
		return result;
	}

}
