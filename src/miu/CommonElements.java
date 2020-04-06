package miu;

/*
 * 
 * Write a function to return an array containing all elements common to two given arrays 
containing distinct positive integers. You should not use any inbuilt methods. 
You are allowed to use any number of arrays.
*/

import java.util.Arrays;

public class CommonElements {
	public static void main(String[] args) {
		int[] firstArray = { 1, 2, 3, 6 };
		int[] secondArray = { 1, 2, 3, 4, 5, 6 };
		int[] output = commonElements(firstArray, secondArray);
		System.out.println(Arrays.toString(output));
	}

	static int[] commonElements(int[] firstArray, int[] secondArray) {
		if (firstArray == null || secondArray == null)
			return null;
		if (firstArray.length == 0 || secondArray.length == 0)
			return new int[0];
		int min = (firstArray.length < secondArray.length) ? firstArray.length : secondArray.length;
		int[] a, b;
		if (min == firstArray.length) {
			a = firstArray;
			b = secondArray;
		} else {
			a = secondArray;
			b = firstArray;
		}
		int[] c = new int[min];
		int k = 0;
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b.length; j++)
				if (a[i] == b[j]) {
					c[k] = a[i];
					k++;
				}
		int[] retArray = new int[k];
		for (int t = 0; t < retArray.length; t++)
			retArray[t] = c[t];
		return retArray;
	}
}
