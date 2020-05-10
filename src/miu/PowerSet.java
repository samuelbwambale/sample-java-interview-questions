package miu;

/*
 * Given a List L without duplicate elements, return another list that consists of all
subsets of L (without duplicates)
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(powerSet(list));
    }

    static List<Set<Integer>> powerSet(List<Integer> originalSet) {
        int size = originalSet.size();
        List<Set<Integer>> powerSet = new ArrayList<>();
        for( long i = 0; i < (1 << size); i++) {
            Set<Integer> element = new HashSet<Integer>();
            for( int j = 0; j < size; j++ )
                if( (i >> j) % 2 == 1 ) element.add(originalSet.get(j));
            powerSet.add(element);
        }
        return powerSet;
    }
}
