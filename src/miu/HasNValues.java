package miu;



/*
 * Write a function named hasNValues which takes an array and an integer n as arguments.
 * It returns true if all the elements of the array are one of n different values.
 *
 * {1, 2, 2, 1}	n=2	returns 1 (because there are 2 different element values, 1 and 2)
	{1, 1, 1, 8, 1, 1, 1, 3, 3}	n=3	returns 1 (because there are 3 different element values, 1, 3, 8)
	{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10}	n=10	returns 1 (because there are 10 different element values)
	{1, 2, 2, 1} n=3	returns 0 (because there are 2 different element values, not 3 as required)
	{1, 1, 1, 8, 1, 1, 1, 3, 3}	n=2	returns 0 (because there are 3 different element values, not 2 as required)
	{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10}	n=20	returns 0 (because there are 10 different element values, not 20 as required)

*/
import java.util.HashMap;

public class HasNValues {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 8, 1, 1, 1, 3, 3};
        int result = hasNValues(arr, 3);
        System.out.println(result);
    }

    public static int hasNValues(int[] a, int n) {

        if (a.length < n)
            return 0;

        HashMap<Integer, Integer> distinct = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (!distinct.containsKey(a[i])) {
                distinct.put(a[i], a[i]);
            }
        }
        if (distinct.size() == n) {
            return 1;
        }
        return 0;

    }
}

