package miu;

public class MinimumElementInSortedRotatedArray {
    public static void main(String[] args) {
        System.out.println(minElementSortedRotatedArray(new int[]{5, 6, 1, 2, 3, 4}));
        System.out.println(minElementSortedRotatedArray(new int[]{1, 2, 3, 4}));
        System.out.println(minElementSortedRotatedArray(new int[]{3, 2}));
    }

    public static int minElementSortedRotatedArray(int[] arr) {
        if(arr.length == 1) return arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] > arr[i]) return arr[i];
        }

        return arr[0];
    }
}
