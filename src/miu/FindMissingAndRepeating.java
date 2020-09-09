package miu;

import java.util.Arrays;

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        int[] array = {5, 6, 6, 3, 2}; //  2, 3, 5, 6, 6
        int[] result = missingAndRepeating(array);
        System.out.println("Repeating is " + result[0] + " Missing is " + result[1]);
    }

    public static int[] missingAndRepeating(int[] arr) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int missing = Integer.MIN_VALUE;
        int repeating = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(i+1 < arr.length && arr[i] == arr[i+1])
                repeating = arr[i];
            if(i+1 < arr.length && arr[i+1] != arr[i]+1)
                missing = arr[i] + 1;
//            else
//                missing = arr[0] - 1;

        }
        result[0] = repeating;
        result[1] = missing;

        return result;
    }
}
