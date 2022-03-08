package miu;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max_sum = nums[0];
        int current_sum = max_sum;

        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.max(current_sum + nums[i], nums[i]);
            max_sum = Math.max(current_sum, max_sum);
        }

        return max_sum;
    }
}

