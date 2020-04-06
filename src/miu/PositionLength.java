package miu;

/*
 * Write a function that accepts a character array, a zero-based start position and a length. 
It should return a character array containing containing `length` characters 
starting with the `start` character of the input array. 
The function should do error checking on the start position and the length 
and return null if the either value is not legal.
*/

public class PositionLength {
	public static void main(String[] args) {
		char[] x = { 'a', 'b', 'c' };
		char[] output = positionLength(x, 2, 1);
		System.out.println(output);
	}

	static char[] positionLength(char[] a, int start, int len) {
		char[] newArray = new char[len];
		if (start < 0 || len < 0 || len > a.length || (start + len - 1) > a.length)
			return null;

		for (int i = start, j = 0; j < len; i++, j++) {
			newArray[j] = a[i];
		}
		return newArray;
	}
}
