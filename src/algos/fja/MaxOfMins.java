package algos.fja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array [2, 5, 3,-4, -2, 7, 1, 0], k =3 return the maximum of the minimums
 */
public class MaxOfMins {
    public static void main(String[] args) {

        System.out.println(getMaxOfMins(Arrays.asList(2, 5, 3,-4, -2, 7, 1, 0),3));
        System.out.println(getMaxOfMins2(Arrays.asList(2, 5, 3,-4, -2, 7, 1, 0),3));
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

        int min = 0;
        for (int i = 0; i < space.size() - k; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i, m = 0; m < k; j++, m++) { // 0,1,2
                temp.add(space.get(j));
            }
            min = minOfSubList(temp);
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

        List<Integer> temp = new ArrayList<>();
        for (int m = 0; m < k; m++) { // 0,1,2
            temp.add(space.get(m));
        }
        int min = minOfSubList(temp);
        int max = min;


        for (int i = k; i < space.size(); i++) {
            min = min < space.get(i) ? min : space.get(i);
            max = max > min ? max : min;
        }

        return max;
    }
}
