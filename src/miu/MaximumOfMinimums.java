package miu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find the maximum of the minimums for the segments of k
 */
public class MaximumOfMinimums {
    public static void main(String[] args) {

        System.out.println(getMaxOfMins(Arrays.asList(2, 5, 3,-4, -2, 7, 1, 0),3));
        System.out.println(getMaxOfMins2(Arrays.asList(2, 5, 3,-4, -2, 7, 1, 0),3));
        System.out.println(getMaxOfMins3(Arrays.asList(2, 5, 3,-4, -2, 7, 4, 3),3));
        //2, 5, 3 = 2
        //5, 3, -4 = -4
        //3, -4, -2 = -4
        //-4, -2, 7 = -4
        //-2, 7, 1 = -2
        //7, 1, 0 = 0
        // ans is 2
    }

    static int getMaxOfMins(List<Integer> space, int k) {
        if(space == null || space.size() < k) return 0;
        int max = 0;


        for (int i = 0; i < space.size() - k; i++) {
            List<Integer> temp = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int j = i, m = 0; m < k; j++, m++) { // 0,1,2
                temp.add(space.get(j));
                min = Math.min(min, space.get(j));
            }
            max = max > min ? max : min;
        }

        return max;
    }

    static int minOfSubList(List<Integer> temp) {
        int smallest = temp.get(0);
        for (int i = 0; i < temp.size(); i++) {
            smallest = smallest < temp.get(i) ? smallest : temp.get(i);
        }

//        int smallest = a;
//        if (smallest > b) smallest = b;
//        if (smallest > c) smallest = c;
        return smallest;
    }

    static int getMaxOfMins2(List<Integer> space, int k) {
        if(space == null || space.size() < k) return 0;

        // Get min between 0 to k-1
        List<Integer> temp = new ArrayList<>();
        for (int m = 0; m < k; m++) { // 0,1,2
            temp.add(space.get(m));
        }
        int min = minOfSubList(temp);
        int max = min;


        // compare current min with each additional element in the array
        for (int i = k; i < space.size(); i++) {
            min = min < space.get(i) ? min : space.get(i);
            max = max > min ? max : min;
        }

        return max;
    }

    static int getMaxOfMins3(List<Integer> space, int k) {
        if(space == null || space.size() < k) return 0;
        int max = Integer.MIN_VALUE;


        for (int i = 0; i <= space.size() - k ; i++) {
            int min = space.get(i);
            for (int j = i; j < i+k; j++) {
                min = Math.min(min, space.get(j));

            }
            max = Math.max(max, min);
        }

        return max;
    }

    static int maxOfMinimumsDanny(int[] array,int k)
    {
        int end = 0;
        int max = array[0];
        for(int i = 0;i < array.length;i++)
        {
            int currMin = array[i];
            for(int j = i+1;j < i + k;j++)
            {
                currMin = Math.min(array[j],currMin);
            }
            max = Math.max(max,currMin);
        }
        return max;
    }
}
