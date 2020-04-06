package miu;

/*
 * An array is defined to be stepped if it is in ascending order 
and there are 3 or more occurrences of each distinct value in the array. 
Note that ascending order means a[n]<=a[n+1]. 
It does not mean a[n] (this is strictly ascending). 
Write a function named isStepped that returns 1 if its array argument is stepped, 
otherwise return 0.
If you are programming in Java or C#, the signature is int isStepped(int[ ] a)

{1, 1, 1, 5, 5, 5, 5, 8, 8, 8}	returns 1	It is in ascending order. The distinct values of the array are 1, 5, 8 and there are three or more occurrences of each of these values.
{1, 1, 5, 5, 5, 5, 8, 8, 8} returns	0	Even though it is in ascending order, there are only two occurrences of the value 1.
{5, 5, 5, 15}	returns 0	Even though it is in ascending order, there is only one occurrence of the value 15.
{3, 3, 3, 2, 2, 2, 5, 5, 5}	 returns 0	It is not in ascending order
{3, 3, 3, 2, 2, 2, 1, 1, 1}	returns 0	It is not in ascending order
{1, 1, 1}	returns 1	It is in ascending order and there are three or more occurrences of each distinct value. In this case there is only one distinct value.
{1, 1, 1, 1, 1, 1, 1}	returns 1	It is in ascending order and there are three or more occurrences of each distinct value. 
In this case there is only one distinct value.

*/
import java.util.HashMap;

public class IsStepped {
	public static void main(String[] args) {
		int[] a = { 3, 3, 3, 3, };
		int result = isStepped(a);
		System.out.println(result);

	}

	static int isStepped(int[] a) {

		HashMap<Integer, Integer> distinct = new HashMap<Integer, Integer>();

		for (int i = 0; i <= a.length - 1; i += 1) {

			if (i + 1 < a.length && a[i] > a[i + 1]) {
				return 0;
			}
			if (distinct.containsKey(a[i])) {
				distinct.put(a[i], distinct.get(a[i]) + 1);
			} else {
				distinct.put(a[i], 1);
			}

		}

		int result = 1;
		for (int i : distinct.values()) {
			if (i < 3) {
				result = 0;
				break;
			}
		}
		return result;
	}

}
