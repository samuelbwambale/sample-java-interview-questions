package miu;

/*
Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point
in the array, if there is any Fixed Point present in array, else returns -1.
Fixed Point in an array is an index i such that arr[i] is equal to i.
Note that integers in array can be negative.

Give a o(n) (“little-oh”) algorithm for determining whether a
sorted array A containing n distinct integers contains an element m for which
A[m] = m. You must also provide a proof that your algorithm runs in o(n) time.
 */
public class FixedPointInArray {

    public static void main(String[] args) {
        int[] arr1 = {-10, -5, 0, 3, 7, 9};
        int[] arr2 = {2, 5, 8, 17, 5};
        int[] arr3 = {-10, -5, 3, 4, 7, 9};
        System.out.println("-----iterative-------");
        System.out.println(findFixedPointIterative(arr1));
        System.out.println(findFixedPointIterative(arr2));
        System.out.println(findFixedPointIterative(arr3));

        System.out.println("-----recursive-------");
        System.out.println(findFixedPointRecursive(arr1, 0, arr1.length - 1));
        System.out.println(findFixedPointRecursive(arr2, 0, arr2.length - 1));
        System.out.println(findFixedPointRecursive(arr3, 0, arr3.length - 1));

    }

    // Time Complexity: O(n)
    static boolean findFixedPointIterative(int[] arr) {
        int i=0, j = arr.length -1;
        while(i <= j) {
            if( i == arr[i] || j == arr[j]) return true;
            else {
                i++;
                j--;
            }
        }
        return false;
    }

    // Time Complexity: O(log(n))
    static boolean findFixedPointRecursive(int arr[], int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if (mid == arr[mid])
                return true;
            if (mid > arr[mid])
                return findFixedPointRecursive(arr, (mid + 1), high);
            else
                return findFixedPointRecursive(arr, low, (mid - 1));
        }
        return false;
    }
}
