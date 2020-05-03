package miu;

/*
For example, when you sideways sort the input array {1, 2, 17, -4, ‐6, 8} you get:
{-6, 17, -4, 8, 1, 2}. (Notice that –6 is the smallest, 17 the largest, -4 second smallest,
8 second largest, etc.) Answer the following:
 */
public class SideWaysSorting {

    public static void main(String[] args) {

        int[] arr = {1, 2, 17, -4, -6, 8, 1};
        int[] result = sideWaysSort(arr);
        for (int i = 0; i < result.length ; i++) {
            System.out.print(result[i] + ", ");
        }
        // expected output {-6, 17, -4, 8, 1, 2, 1}
    }

    static int[] sideWaysSort(int[] a) {
        if(a.length == 1 || a == null) return a;
        int[] arr = sort(a);
        int[] temp = new int[arr.length];
        for (int i = 0, j = arr.length - 1, k = 0; i <= j; i++, j--, k = k + 2) {
            if(i != j) {
                temp[k] = arr[i];
                temp[k+1] = arr[j];
            }
            else if (i == j) {
                temp[k] = arr[i];
            }
        }
        return temp;

    }

    static int[] sort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int[][] arrays = partition(arr, n/2);
            int[] sortedL1 = sort(arrays[0]);
            int[] sortedL2 = sort(arrays[1]);

            int[] result = merge(sortedL1, sortedL2);
            return result;
        }
        return arr;
    }

    static int[][] partition(int[] arr, int halfN) {

        int n = arr.length;
        int[] L1 = new int[halfN];
        int[] L2 = new int[n - halfN];

        System.arraycopy(arr, 0, L1, 0, L1.length);
        System.arraycopy(arr, L1.length, L2, 0, L2.length);

        int[][] arrays = { L1, L2};
        return arrays;
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];

        while (i<n1 && j <n2) {
            if (arr1[i] < arr2[j])
                mergedArray[k++] = arr1[i++];
            else
                mergedArray[k++] = arr2[j++];
        }

        while (i < n1)
            mergedArray[k++] = arr1[i++];

        while (j < n2)
            mergedArray[k++] = arr2[j++];

        return mergedArray;
    }
}
