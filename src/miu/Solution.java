package miu;

/*
Prison Labor Dodgers
====================

Commander Lambda is all about efficiency, including using her bunny prisoners for manual labor.
But no one's been properly monitoring the labor shifts for a while, and they've gotten quite mixed up.
You've been given the task of fixing them, but after you wrote up new shifts,
you realized that some prisoners had been transferred to a different block and aren't available for their assigned shifts.
And manually sorting through each shift list to compare against prisoner block lists will take forever - remember,
Commander Lambda loves efficiency!

Given two almost identical lists of prisoner IDs x and y where one of the lists contains an additional ID,
write a function solution(x, y) that compares the lists and returns the additional ID.

For example, given the lists x = [13, 5, 6, 2, 5] and y = [5, 2, 5, 13],
the function solution(x, y) would return 6 because the list x contains the integer 6
and the list y doesn't. Given the lists x = [14, 27, 1, 4, 2, 50, 3, 1] and y = [2, 4, -4, 3, 1, 1, 14, 27, 50],
the function solution(x, y) would return -4 because the list y contains the integer -4 and the list x doesn't.

In each test case, the lists x and y will always contain n non-unique integers where n is at least 1
but never more than 99, and one of the lists will contain an additional unique integer which should be returned by the function.
The same n non-unique integers will be present on both lists, but they might appear in a different order,
like in the examples above. Commander Lambda likes to keep her numbers short,
so every prisoner ID will be between -1000 and 1000.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] x =  {14, 27, 1, 4, 2, 50, 3, 1};
        int[] y =  {2, 4, -1000, 3, 1, 1, 14, 27, 50};
        System.out.println(Solution.solution(x,y));

        int[] a = {13, 5, 6, 2, 5};
        int[] b = {5, 2, 5, 13};
        System.out.println(Solution.solution2(a,b));

        System.out.println(Solution.solution3(x,y));
    }

    public static int solution(int[] x, int[] y) {
        int result = 0;
//        Set<Integer> setX = new HashSet<>(Arrays.asList(x));
//        Set<Integer> setY = new HashSet<>(Arrays.asList(y));

        Set<Integer> setX = Arrays.stream(x).boxed().collect(Collectors.toSet());
        Set<Integer> setY = Arrays.stream(y).boxed().collect(Collectors.toSet());

        Set<Integer> bigSet = setX.size() > setY.size() ? setX : setY;
        Set<Integer> smallSet = setX.size() < setY.size() ? setX : setY;

        for(Integer element : bigSet){
            if(!smallSet.contains(element)) {
                result = element;
                break;
            }
        }
        return result;
    }

    public static int solution3(int[] x, int[] y) {
        Set<Integer> setX = Arrays.stream(x).boxed().collect(Collectors.toSet());
        Set<Integer> setY = Arrays.stream(y).boxed().collect(Collectors.toSet());

        Set<Integer> intersection = new HashSet<>(setX);
        intersection.retainAll(setY);

        Set<Integer> difference = new HashSet<Integer>();
        difference.addAll(setX);
        difference.addAll(setY);
        difference.removeAll(intersection);

        for (Integer element : difference) return element;
        return 0;
    }

    public static int solution2(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        if(x.length > y.length) {
            for (int i = 0; i < x.length; i++) {
                if(i == x.length -1 ) return x[i];
                if(x[i] != y[i]) return x[i];

            }
        } else if(x.length < y.length){
            for (int j = 0; j < y.length; j++) {
                if(j == y.length -1 ) return y[j];
                if(y[j] != x[j]) return y[j];

            }
        }
        return 0;
    }




    public static int[] sort(int[] arr) {
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

    static int[][] partition(int[] arr, int halfOfLength) {

        int n = arr.length;
        int[] L1 = new int[halfOfLength];
        int[] L2 = new int[n - halfOfLength];

        System.arraycopy(arr, 0, L1, 0, halfOfLength);
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
