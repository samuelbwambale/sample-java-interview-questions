package algos.fja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        generateSubArrays(Arrays.asList(1,2,3));

        System.out.println();
        System.out.println("lengthOflongestSubArraySumsToK");
        System.out.println("Solution " + lengthOflongestSubArraySumsToK(Arrays.asList(3,4,7,2,-3,1,4,2), 7));

        System.out.println();
        System.out.println("longestSubArraySumsToK");
        System.out.println("Solution " + longestSubArraySumsToK(Arrays.asList(3,4,7,2,-3,1,4,2), 7));

        System.out.println();
        System.out.println("lengthOflongestSubArraySumsToK - Danny");
        System.out.println(longestSubArrDanny(new int[] {3,4,7,2,-3,1,4,2},7));
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
                    System.out.println("Possible solution: " + tempLen);
                    maxLen = maxLen > tempLen ? maxLen : tempLen;
                }
            }
        }
        return maxLen;
    }

    public static List<Integer> longestSubArraySumsToK(List<Integer> arr, int k) {
        int cumSum = 0;
        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int tempSum = cumSum;
            for (int j = i; j < arr.size(); j++) {
                cumSum += arr.get(j);
                if(cumSum - tempSum <= k) {
                    List<Integer> tempArray = new ArrayList<>();
                    for (int l = i; l <=j ; l++) {
                        tempArray.add(arr.get(l));
                    }
                    System.out.println("Possible solution: " + tempArray);
                    solution = solution.size() > tempArray.size() ? solution : tempArray;
                }
            }
        }

        return solution;
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
}
