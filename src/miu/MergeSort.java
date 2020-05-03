package miu;

public class MergeSort {

        public static void main(String[] args) {

            System.out.println(3/2);

            int[] arr = {3, 5, 6, 9, 1, 4};

            int[] L1 = {1, 2, 3};
            int[] L2 = {2, 6, 7};
            System.out.println("Test merge method ------------------------");
            int[] testMerge = merge(L1,L2);
            for (int i = 0; i < testMerge.length; i++) {
                System.out.print(testMerge[i] + ", ");
            }

            System.out.println();
            System.out.println("Test sort method------------------------");
            MergeSort mergeSort = new MergeSort();
            int[] sorted = mergeSort.sort(arr);
            for (int i = 0; i < sorted.length; i++) {
                System.out.print(sorted[i] + ", ");
            }



        }

        /*
        Recurrance relation:  T(1) = 3, T(n) ≤ 2T(n/2) + cn
        From Master Formula, running time = O(n*log(n))
         */

        public int[] sort(int[] arr) {
            int n = arr.length;
            if (n > 1) {
                int[][] arrays = partition(arr, n/2);   // O(n)
                int[] sortedL1 = sort(arrays[0]);   // T(n/2)
                int[] sortedL2 = sort(arrays[1]);   // T(n/2)

                int[] result = merge(sortedL1, sortedL2); //  O(n)
                return result;
            }
            return arr;
        }

        static int[][] partition(int[] arr, int halfOfLength) {

            int n = arr.length;
            int[] L1 = new int[halfOfLength];
            int[] L2 = new int[n - halfOfLength];

            System.arraycopy(arr, 0, L1, 0, halfOfLength);
            System.arraycopy(arr, L1.length, L2, 0, L2.length);

            int[][] arrays = { L1, L2};
            return arrays;
        }

    // implemented in class MergeSortedArrays
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

            // remaining elements of first arr1
            while (i < n1)
                mergedArray[k++] = arr1[i++];

            // remaining elements of arr2
            while (j < n2)
                mergedArray[k++] = arr2[j++];

            return mergedArray;
        }


}
