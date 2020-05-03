package miu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Given a list L = [s0, s1, . . ., sn−1] of n distinct positive integers and a non-negative
integer k, determine whether there is a subset of L the sum of whose values is k. Do this by
implementing the following Java method.

Hint. Use a solution to Problem 6 as part of your solution to this problem. A solution in the
form of a jar file is provided for you so that you can try using it here even if you do not have
your own solution to Problem 6.
* */

public class SubSetSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(4);
        list.add(8);
        list.add(5);
        System.out.println(subsetSum(list, 22));

    }
    public static boolean subsetSum(List list, int z) {
        List<Set<Integer>> P = PowerSet.powerSet(list);
        for(Set<Integer> subSet : P) {
            int sumOfSubSet = 0;
            for(Integer i : subSet) {
                sumOfSubSet += i;
            }
            if(z == sumOfSubSet) return true;
        }
        return false;
    }

}
