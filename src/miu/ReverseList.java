
package miu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ReverseList {

    public static void main(String[] args) {
        // List of Random integers
        List<Integer> list = new ArrayList<>();
        Random RandomInt = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(RandomInt.nextInt(10));
        }

        long preTime=System.currentTimeMillis();
        System.out.println(reverseListIteratively(list));
        long postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute (reverseListIteratively) in milliseconds->"+(postTime-preTime));


        preTime=System.currentTimeMillis();
        System.out.println(reverseListRecursively(list, 0, list.size()-1));
        postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute (reverseListRecursively) in milliseconds->"+(postTime-preTime));

        preTime=System.currentTimeMillis();
        System.out.println(reverseListRecursively2(list));
        postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute (reverseListRecursively2) in milliseconds->"+(postTime-preTime));
    }

    static List<Integer> reverseListIteratively(List<Integer> list) {
        if (list.size() <= 1) return list;

        List<Integer> reversed = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }

        return reversed;
    }



    static List<Integer> reverseListRecursively(List<Integer> list,int startIndex,int lastIndex) {
        if (list.size() <= 1 || list == null) return list;
        else if(startIndex<lastIndex) {
            Integer lastElement=list.get(lastIndex);
            list.set(lastIndex,list.get(startIndex));
            list.set(startIndex,lastElement);
            startIndex++;
            lastIndex--;
            reverseListRecursively(list,startIndex,lastIndex);
        }
        return list;
    }

    static List<Integer> reverseListRecursively2(List<Integer> list) {
        if (list.size() <= 1) return list;

        List<Integer> reversed = new ArrayList<>(list.size());
        reversed.add(list.get(list.size() - 1)); // last element
        reversed.addAll(reverseListRecursively2(list.subList(0, list.size() - 1)));
        return reversed;
    }

}
