package miu;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[] {1, 2,3, 5}, 5);
        System.out.println(result[0] + ", " + result[1]);
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
        }

        return result;
    }
}
