package miu;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedWord {
    public static void main(String[] args) {
        String arr[] = { "ccc", "aaa", "ccc", "ddd", "aaa", "aaa", "ddd" };
        System.out.println(secondMostRepeated(arr));
    }

    public static String secondMostRepeated(String[] arr) {
        int len = arr.length;
        if(len == 1) return arr[0];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = 0;
        int secondMax = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > max) {
                secondMax = max;
                max = entry.getValue();
            }
            if(entry.getValue() > secondMax && entry.getValue() != max)
                secondMax = entry.getValue();
        }

        String result = "";
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == secondMax) {
                result = entry.getKey();
                break; // we assume there is only one secondMax
            }
        }

        return result;
    }
}


