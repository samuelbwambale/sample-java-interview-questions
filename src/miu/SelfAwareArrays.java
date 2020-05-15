package miu;

/*
An array A of size n is self-aware if, for each i < n, A[i] is the exact number of occurrences of i in A. Example:
A = [2, 0, 2, 0]
(A[0] = 2 and A contains two occurrences of 0. A[1] = 0 and A contains 0 occurrences of 2. A[2] = 2
and A contains two occurrences of 2. A[3] = 0 and A contains 0 occurrences of 3.) For this problem, you must do the following:

1. [6 points] Implement the following function.
public static List<int[]> allSelfAwareArrays(int n)
This function should accept any positive integer n and return a list of all self-aware arrays of length n.
For instance, in the return list L for allSelfAwareArrays, on input 4, one of the arrays that should belong to L is [2, 0, 2, 0].
You must provide a main method that will print to console the list of arrays returned for each positive integer n.
For full credit on this part of the problem, your function must be able to return the full list of all self-aware arrays
for each of the inputs 1, 2, 3, ..., 7. Points will be deducted if any of your lists contain arrays that are not self-aware.
Note: You will not get full credit if your code cannot be executed for n = 7 (if, after several minutes of running, the application does not end, I will assume that you have run out of memory).
2. [3 points] What is the running time of your algorithm? If it is exponential or worse, prove that.
If it runs in polynomial time, then give the asymptotic running time and prove your answer.


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* Name of the class has to be "Main" only if the class is public. */
public class SelfAwareArrays {

    private static int permCount = 0;
    private static int filterCount = 0;

    public static void main (String[] args) throws Exception {
        int n = 5;
        List<int[]> result = allSelfAwareArrays(n);
        System.out.println("Total number of permutation arrays: " + permCount);
        System.out.println("Number of filtered arrays: " + filterCount);

        String txt = result.size() > 0 ? "Self-Aware Arrays for n = "+ n : "No Self-Aware Arrays for n = "+ n;
        System.out.println(txt);
        result.forEach(arr->System.out.println(Arrays.toString(arr)));
    }

    static void generatePermutations(int[] perm, int pos, int[] arr, List<int[]> listOfArrays) {
        if (pos == perm.length) {
//            System.out.println(Arrays.toString(perm));
            int sum = sumOfArray(perm);
            if (perm[0] != 0 && sum == perm.length) {
                boolean isSelfAware = checkSelfAwareArray(perm);
                if (isSelfAware){
                    int[] temp = new int[perm.length];
                    System.arraycopy(perm, 0,temp,0,perm.length);
                    listOfArrays.add(temp);
                }
                filterCount++;
            }
            permCount++;

        } else {
            for (int i = 0 ; i < arr.length ; i++) {
                perm[pos] = arr[i];
                generatePermutations(perm, pos+1, arr, listOfArrays);
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

    static int sumOfArray(int[] arr) {
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

        generatePermutations(perm, 0, arr, selfAwareArrays);
        return selfAwareArrays;
    }

}