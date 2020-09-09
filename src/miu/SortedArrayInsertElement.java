package miu;

import java.util.Arrays;

// Inserts an element in arr[] of given
// capacity.  n is current size of arr[].
// This function returns n+1 if insertion
// is successful, else n.
public class SortedArrayInsertElement {
    public static void main(String[] args) {
        int arr[] = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = arr.length;
        int n = 6;
        int element = 76;

        System.out.print("\nBefore Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("Current size: " + n);

        // Inserting key
        n = insertSorted(arr, n, element, capacity);

        System.out.print("\nAfter Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("Current size: " + n);


        System.out.println();
        System.out.println(Arrays.toString(insertSorted2(new int[] {2,4,6,7,8}, 29)));
    }



    // Inserts an element in arr[] of given
    // capacity.  n is current size of arr[].
    // This function returns n+1 if insertion
    // is successful, else n.
    public static int insertSorted(int arr[], int n, int element, int capacity)
    {
        // Cannot insert more elements if n is already
        // more than or equal to capacity
        if (n >= capacity)
            return n;

//        int i;
//        for (i = n - 1; (i >= 0 && arr[i] > element); i--)
//            arr[i + 1] = arr[i];

        int i = n - 1;
        while(i >= 0 && arr[i] > element) {
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = element;

        return (n + 1);
    }

    public static int[] insertSorted2(int[] arr, int element) {
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, arr.length);
        int i;
        for(i=0;i<result.length-1;i++){
            if(result[i]>element)
                break;
        }
        for(int k=result.length-2; k>=i; k--){
            result[k+1]=result[k];
        }
        result[i]=element;

        System.out.println(Arrays.toString(arr));

        return result;
    }
}
