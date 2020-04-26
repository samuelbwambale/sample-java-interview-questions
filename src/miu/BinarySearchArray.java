package miu;


/*
Suppose the array arr is already known to be in sorted order. Can you write a more efficient
program for determining whether z is in arr? If yes, why do you think your solution to than that of unsorted Array
is faster?

ANSWER
The solution for a sorted array is faster because we don't need to go through all the elements to search our element,
instead we discard half elements in each iteration.

We directly jump to middle element and see if the element is matching our search term, z.
If it is, we return it. If z is less than the middle element then we need to search on sub array present
on left side of middle element and ignore the right sub array. If z is greater than the middle element then we need to search
 on sub array present on right side of middle element and ignore the left sub array.

*/
public class BinarySearchArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long preTime=System.currentTimeMillis();
        System.out.println(find(arr, 9));
        long postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute (find) in milliseconds->"+(postTime-preTime));

        preTime=System.currentTimeMillis();
        System.out.println(binSearchRecursive(arr, 0, arr.length, 9));
        postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute (binSearchRecursive) in milliseconds->"+(postTime-preTime));
    }

    // base cases: array.length = 0 || z = arr[mid]
    /*
    Search Iteratively
     */
    public static boolean find(int[] arr, int z) {
        if(arr==null || arr.length<0){
            return false;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (z == arr[mid]) {
                return true;

            } else if (z < arr[mid]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    /*
    Search Recursively
     */
    // Returns index of x if it is present in arr[l..r], else return -1
    // At start, l -> left = 0, r-> right =  arr.length
    // passing the lower and upper index solves the problem of re-creating the L and R arrays if arr[mid] != x
    public static int binSearchRecursive(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binSearchRecursive(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binSearchRecursive(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}


