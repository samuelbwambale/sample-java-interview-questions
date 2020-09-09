package miu;

public class SortedArraySearchElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 9, 12};

        System.out.println(findK(arr, 2));

    }

    public static int findK(int[] arr, int key) {

        return binarySearch(arr, 0, arr.length -1 , key);
    }

    public static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /*low + (high - low)/2;*/
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }
}
