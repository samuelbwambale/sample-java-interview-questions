package miu;

public class DotProductOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(dotProduct(new int[] {3, -5, 4}, new int[] {2, 6, 5})); // -4
    }

    public static int dotProduct(int[] arr1, int[] arr2)
    {

        int n = arr1.length;
        int product = 0;

        // Loop for calculate dot product
        for (int i = 0; i < n; i++)
            product = product + arr1[i] * arr2[i];
        return product;
    }
}
