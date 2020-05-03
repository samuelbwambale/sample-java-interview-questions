package miu;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 0, 1, 2, 0, 1, 1};
        int[] result = sortZerosOnesTwos(arr);
        for (int i = 0; i < result.length -1 ; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    // sorts array in O(n)
    static int[] sortZerosOnesTwos(int[] arr) {
        int zerosCounter = 0, onesCounter = 0;
        for (int i = 0; i < arr.length -1 ; i++) {
            if(arr[i] == 0) zerosCounter++;
            if(arr[i] == 1) onesCounter++;
        }
        for (int i = 0; i < arr.length -1; i++) {
            if(i < zerosCounter)
                arr[i] = 0;
            else if(i >= zerosCounter && i < zerosCounter + onesCounter )
                arr[i] = 1;
            else arr[i] = 2;
        }

        return arr;


    }


}
