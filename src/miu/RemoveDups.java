package miu;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDups {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(9);
        list.add(9);
        ArrayList<Integer> result = removeDups(list);
        System.out.println(result);
    }

    static ArrayList<Integer> removeDups(ArrayList<Integer> list) {
        ArrayList<Integer> distinct = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if(!map.containsKey(list.get(i))) {
                map.put(list.get(i), list.get(i));
                distinct.add(list.get(i));
            }
        }
        return distinct;
    }
}
