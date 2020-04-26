package miu;

/*
Suppose the array arr is already known to be in sorted order. Can you write a more efficient
program for determining whether z is in arr? If yes, why do you think your solution to (B)
is faster?

ANSWER
The solution for a sorted array is faster because we don't need to go through all the elements to search our element,
instead we discard half elements in each iteration.

We directly jump to middle element and see if the element is matching our search term, z.
If it is, we return it. If z is less than the middle element then we need to search on sub array present
on left side of middle element and ignore the right sub array. If z is greater than the middle element then we need to search
 on sub array present on right side of middle element and ignore the left sub array.

*/
public class SearchElement_SortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(find(arr, 9));
    }

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

    // TO BE IMPROVED
}
