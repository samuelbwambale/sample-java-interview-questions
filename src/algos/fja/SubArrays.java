package algos.fja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        generateSubArrays(Arrays.asList(1,2,3));

        System.out.println();
        System.out.println("lengthOflongestSubArraySumsToK");
        System.out.println("Solution " + lengthOflongestSubArraySumsToK(Arrays.asList(3,4,7,2,-3,1,4,2), 7));
//
//        System.out.println();
//        System.out.println("longestSubArraySumsToK");
//        System.out.println("Solution " + longestSubArraySumsToK(Arrays.asList(3,4,7,2,-3,1,4,2), 7));
//
        System.out.println();
        System.out.println("lengthOflongestSubArraySumsToK - Danny");
        System.out.println(longestSubArrDanny(new int[] {3,4,7,2,-3,1,4,2},7));

        System.out.println();
        System.out.println("longestSubArraySumsToK_2");
        System.out.println(longestSubArraySumsToK_2(new int[] {3,4,7,2,-3,1,4,2},7));

        System.out.println();
        System.out.println("numberOfSubarraySumToK");
        System.out.println(numberOfSubarraySumToK(new int[] {3,4,7,2,-3,1,4,2},7));

        System.out.println();
        System.out.println("numberOfSubarraySumToK2");
        System.out.println(numberOfSubarraySumToK2(new int[] {3,4,7,2,-3,1,4,2},7));
    }

    public static void generateSubArrays(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < arr.size(); j++) {
                temp.add(arr.get(j));
                System.out.println(temp);
            }

        }
    }
/*
A Subarray of A is defined as a contiguous block of A's elements having a length that is less than or equal to
the length of the array A. For example, subarrays of {1,2,3} are {1}, {1,2}, {1,2,3}, {2}, {2,3}, {3}.
Given an integer k = 3, the subarrays having elements that sum to a number <=k are {1,2} and {3}. The longest of these subarrays
is {1,2} which has length 2. Given an array, A determine its longest subarray that sums up to less than or equal to
a given value, k.

maxLength(int[] arr, k) {
}
 */
    public static int lengthOflongestSubArraySumsToK(List<Integer> arr, int k) {
        int maxLen = Integer.MIN_VALUE;
        int cumSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int tempSum = cumSum;
            for (int j = i; j < arr.size(); j++) {
                cumSum += arr.get(j);
                if(cumSum - tempSum <= k) {
                    int tempLen = j - i + 1;
//                    System.out.println("Possible solution: " + tempLen);
                    maxLen = maxLen > tempLen ? maxLen : tempLen;
                }
            }
        }
        return maxLen;
    }


    public static int longestSubArrDanny(int[] array,int k)
    {
        int right = 0;
        int left = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        while(right < array.length)
        {
            sum += array[right];
            while(sum > k && left < right)
            {
                sum -= array[left++];
            }
            result = Math.max(result,right - left +1);
            right++;
        }
        return result;
    }

    public static int longestSubArraySumsToK_2(int[] arr, int k) {
        int currentMaxLength = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum <= k) {
                    temp.add(arr[j]);
                    if(currentMaxLength < temp.size()) {
                        currentMaxLength = temp.size();
                        result = temp;
                    }
                }
            }




        }
        System.out.println(currentMaxLength);
        System.out.println(result);
        return result.size();
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public static int numberOfSubarraySumToK(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Time complexity O(n*n)
    // Space complexity O(1)
    public static int numberOfSubarraySumToK2(int[] nums, int k) {

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) count++;

            }
        }

        return count;
    }
}
