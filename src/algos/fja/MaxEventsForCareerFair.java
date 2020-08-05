package algos.fja;

import java.util.Arrays;

public class MaxEventsForCareerFair {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3, 3, 5, 7};
        int[] arr2 = new int[] {2, 2, 1, 2, 1};
        System.out.println(maxEvents(arr1, arr2));

    }

    public static int maxEvents(int[] array1,int[] array2)
    {
        int[][] intervals = new int[array1.length][];
        for(int i = 0;i < array1.length;i++)
        {
            intervals[i] = new int[]{array1[i],array2[i]+array1[i]};
        }
        Arrays.sort(intervals,(a1, a2) -> Integer.compare(a1[1],a2[1]));
        int currEndTime = Integer.MIN_VALUE;
        int result = 0;
        for(int i = 0;i < intervals.length;i++)
        {
            if(intervals[i][0] >= currEndTime)
            {
                currEndTime = intervals[i][1];
                result++;
            }
        }
        return result;
    }
}
