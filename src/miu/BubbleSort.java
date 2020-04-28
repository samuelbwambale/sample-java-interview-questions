package miu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[50];
        Random RandomInt = new Random();
        for (int i = 0; i < 50; i++) {
            arr[i] = RandomInt.nextInt(10);
        }
        int[] result = bubbleSort(arr);
        for (int i = 0; i < result.length -1 ; i++) {
            System.out.print(result[i] + ", ");
        }

    }

    static int[] bubbleSort(int[] anArray) {
        int len = anArray.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i- 1; j++)
                if (anArray[j] > anArray[j + 1])
                {
                    // swap anArray[j+1] and anArray[i]
                    int temp = anArray[j];
                    anArray[j] = anArray[j + 1];
                    anArray[j+1] = temp;
                }

        return anArray;
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
