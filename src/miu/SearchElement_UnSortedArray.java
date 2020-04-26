package miu;

/*
* Searching. Given an array arr of ints and an int z.
* */
public class SearchElement_UnSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 2};
        System.out.println(find(arr, 2));
    }

    public static boolean find(int[] arr, int z) {
        if(arr==null || arr.length == 0) {
            throw new IllegalArgumentException("Input array too small");
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == z) return true;
        }
        return false;
    }

    // TO BE IMPROVED
}

