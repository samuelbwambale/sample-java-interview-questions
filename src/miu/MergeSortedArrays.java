package miu;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 8, 17};
        int[] arr2 = {2, 4, 8, 11, 13, 21, 23, 25};
        int[] result = merge(arr1, arr2);
        // expected output 1,2,4,4,5,8,8, 11, 13, 17, 21, 23, 25

        for(int i : result){
            System.out.print(i +", ");
        }

    }

    static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[arr1.length + arr2.length];

        while (i<arr1.length && j <arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i];
                k++;
                i++;
            }
            else
                mergedArray[k++] = arr2[j++];
        }

        // save remaining elements of first arr1
        while (i < arr1.length)
            mergedArray[k++] = arr1[i++];

        // save remaining elements of arr2
        while (j < arr2.length)
            mergedArray[k++] = arr2[j++];

        return mergedArray;
    }
}
