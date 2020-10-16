package algos.jimmy;

/*
1. An integer array is defined to be sequentially-bounded if it is in ascending order and each value, n,
in the array occurs less than n times in the array. So {2, 5, 5, 5, 99, 99, 99, 99, 99} is sequentially-bounded
because it is in ascending order and the value 2 occurs less than 2 times, the value 5 occurs less than 5 times
and the value 99 occurs less than 99 times. On the other hand, the array {1, 2, 3} is not sequentially-bounded
because the value 1 does not occur < 1 times. The array {2, 3, 3, 3, 3} is not sequentially-bounded
because the maximum allowable occurrences of 3 is 2 but 3 occurs 4 times. The array {12, 12, 9} is not sequentially-bounded
because it is not in ascending order.

Write a function named isSequentiallyBounded that returns 1 if its array argument is sequentially-bounded,
otherwise it returns 0.

If you are programming in Java or C#, the function signature is
int isSequentiallyBounded(int[ ] a)

If you are programming in C or C++, the function signature is
int isSequentiallyBounded(int a[ ], int len) when len is the length of the array.

Examples

if a is	returns	Reason
{0, 2}	returns 0	the value 0 has to occur less than 0 times, but it doesn?t
{-1, 2}	returns 0	if array contains a negative number, return 0.
{}	returns 1	since there are no values, there are none that can fail the test.
{5, 5, 5, 5}	returns 1	5 occurs less than 5 times
{5, 5, 5, 2, 5}	returns 0	array is not in ascending order.

 */

import java.util.HashMap;
import java.util.Map;

public class SequentiallyBoundedArray {

    public static void main(String[] args) {
        System.out.println(isSequentiallyBounded(new int[] {12, 12, 9}));

    }

    static int isSequentiallyBounded(int[] a) {
        if(a == null) return 0;

        int len = a.length;
        if(len == 0) return 1;

        if(len == 1 && a[0] < 2) return 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // if array contains a negative number, return 0
            if(a[i] < 0) return 0;
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        }

        for (int i = 0; i < len - 1; i++) {
            if(a[i] > a[i+1] || count.get(a[i]) >= a[i] )
                return 0;
        }

        if(count.get(a[len-1]) >= a[len-1]) return 0;

        return 1;

    }
}
