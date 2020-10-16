package algos.jimmy;

/*
2. An array is defined to be minmax-disjoint if the following conditions hold:

The minimum and maximum values of the array are not equal.
The minimum and maximum values of the array are not adjacent to one another.
The minimum value occurs exactly once in the array.
The maximum value occurs exactly once in the array.
For example the array {5, 4, 1, 3, 2} is minmax-disjoint because

The maximum value is 5 and the minimum value is 1 and they are not equal.
5 and 1 are not adjacent to one another
5 occurs exactly once in the array
2 occurs exactly once in the array
Write a function named isMinMaxDisjoint that returns 1 if its array argument is minmax-disjoint,
otherwise it returns 0.

If you are programming in Java or C#, the function signature is
int isMinMaxDisjoint(int[ ] a)

If you are programming in C or C#, the function signature is
int isMinMaxDisjoint(int a[ ], int len) where len is the number of elements in the array.

Examples of arrays that are not minMaxDisjoint

if a is	return	Reason
{18, -1, 3, 4, 0}	returns 0	The max and min values are adjacent to one another.
{9, 0, 5, 9}	returns 0	The max value occurs twice in the array.
{0, 5, 18, 0, 9}	returns 0	The min value occurs twice in the array.
{7, 7, 7, 7}	returns 0	The min and the max value must be different.
{}	returns 0	There is no min or max.
{1, 2}	returns 0	The min and max elements are next to one another.
{1}	returns 0	The min and the max are the same.

 */
import java.util.HashMap;
import java.util.Map;

public class MinMaxDisjoint {
    public static void main(String[] args) {
        System.out.println(isMinMaxDisjoint(new int[] {}));
    }

    static int isMinMaxDisjoint(int[] a) {

        int len = a.length;
        if(len == 0) return 0;
        if(len == 1) return 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        }

        int max = a[0];
        int min = a[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < len; i++) {
            if(a[i] > max) {
                max = a[i];
                maxIndex = i;
            }

            if(a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }

        if(min == max || Math.abs(minIndex - maxIndex) == 1) return 0;
        if(count.get(max) > 1 || count.get(min) > 1) return 0;

        return 1;

    }
}
