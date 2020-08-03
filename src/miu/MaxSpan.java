package miu;

/*
Consider the leftmost and righmost appearances of some value in an array.
We'll say that the "span" is the number of elements between the two inclusive.
A single value has a span of 1.
Returns the largest span found in the given array. (Efficiency is not a priority.)

maxSpan([1, 2, 1, 1, 3]) → 4
maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6

 */

import java.util.HashMap;
import java.util.Map;

public class MaxSpan {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 1, 4, 1, 4};
        System.out.println(maxSpan(nums));
    }

    public static int maxSpan(int[] nums) {
        int maxSpan = 0;
        if (nums.length<=0) {
            return maxSpan;
        }

        maxSpan = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0; j < nums.length; j++) {
            if(!map.containsKey(nums[j])) {
                map.put(nums[j], j);
            } else {
                int span = j - map.get(nums[j]) + 1;
                maxSpan = Math.max(maxSpan, span);
            }
        }

        return maxSpan;
    }
}
