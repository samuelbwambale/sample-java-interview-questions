package miu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[50];
        Random RandomInt = new Random();
        for (int i = 0; i < 20; i++) {
            arr[i] = RandomInt.nextInt(10);
        }
        int[] result = bubbleSort(arr);
        for (int i = 0; i < result.length ; i++) {
            System.out.print(result[i] + ", ");
        }

    }

    static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        int temp;
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }

    static int[] bubbleSortImproved(int[] anArray) {
        int i, j, temp;
        int n = anArray.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (anArray[j] > anArray[j + 1])
                {
                    temp = anArray[j];
                    anArray[j] = anArray[j + 1];
                    anArray[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }

        return anArray;
    }
}
