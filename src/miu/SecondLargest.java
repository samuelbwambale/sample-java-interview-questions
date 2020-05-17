package miu;

public class SecondLargest {

    public static void main(String[] args) throws Exception {
        System.out.println(secondLargest(new int[]{1, 2, 3, 4}));
        System.out.println(secondLargest(new int[]{4, 1, 2, 3}));
        System.out.println(secondLargest(new int[]{1, 1, 2, 2}));
        System.out.println(secondLargest(new int[]{1, 1}));
        System.out.println(secondLargest(new int[]{1}));
        System.out.println(secondLargest(new int[]{}));

    }

    static int secondLargest(int[] a) throws Exception {
        if (a.length < 2) throw new Exception("Array length should be at least 2");
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > max) {
                secondMax = max;
                max = a[i];
            }

            if (a[i] > secondMax && a[i] != max)
                secondMax = a[i];
        }
        if (secondMax == Integer.MIN_VALUE)
            throw new Exception("There is no second maximum");

        return secondMax;
    }
}

