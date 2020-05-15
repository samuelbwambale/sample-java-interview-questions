package miu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* Name of the class has to be "Main" only if the class is public. */
class PermutationsWithReplacementInt {

    private static void permutation(int[] perm, int pos, int[] arr, List<int[]> listOfArrays) {
        if (pos == perm.length) {
            System.out.println(Arrays.toString(perm));
            int sum = sumOfArray(perm);
            if (perm[0] != 0 && sum == perm.length) {
                boolean isSelfAware = checkSelfAwareArray(perm);
                if (isSelfAware){
                    listOfArrays.add(perm);
                    System.out.println("isSelfAware = TRUE");
//                    System.out.println(Arrays.toString(perm));

                }
            }

        } else {
            for (int i = 0 ; i < arr.length ; i++) {
                perm[pos] = arr[i];
                permutation(perm, pos+1, arr, listOfArrays);
            }
        }
    }

    static boolean checkSelfAwareArray(int[] perm) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        boolean isSelfAware = true;

        // get count of all elements in the array
        for (int i = 0; i < perm.length; i++) {
            if(!countMap.containsKey(perm[i])){
                countMap.put(perm[i], 1);
            }
            else {
                // increment the count by 1
                countMap.put(perm[i], countMap.get(perm[i]) + 1);
            }
        }
        // check if perm[i] is the exact number of occurrences of i in perm[].
        for (int i = 0; i < perm.length; i++) {
            if(countMap.containsKey(i) && perm[i] != countMap.get(i)) {
                isSelfAware = false;
            }
        }
        return isSelfAware;
    }

    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static List<int[]> allSelfAwareArrays(int n) {
        List<int[]> selfAwareArrays = new ArrayList<>();
        int[] perm = new int[n]; // to hold the permutation arrays
        int[] arr = new int[n]; // the original array from 0 to n-1 populated below
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        permutation(perm, 0, arr, selfAwareArrays);
        return selfAwareArrays;
    }

    public static void main (String[] args) throws Exception {

        List<int[]> result = allSelfAwareArrays(4);
        System.out.println();

        System.out.println("Output of ArrayOfArrays");
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }

    }

}
