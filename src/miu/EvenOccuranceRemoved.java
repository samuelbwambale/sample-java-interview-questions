package miu;

/*
Write a function that will accept a String and return a String
where the even occurances of each number have been removed

Example "aabbccaa" -> "abca"
        "a1ab2bc1c" -> "a1b2c"
         "abcabcabccba" -> "abcabc"
 */

import java.util.HashMap;
import java.util.Map;

public class EvenOccuranceRemoved {
    public static void main(String[] args) {
        System.out.println(removeEvenOccurance("abcabcabccba"));
        System.out.println(removeEvenOccurance("b"));

    }

    public static String removeEvenOccurance(String str) {
        int len = str.length();
        if(len <= 1) return str;

        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(map.containsKey(str.charAt(i))) {
                if(map.get(str.charAt(i))%2 != 1) {
                    result += str.charAt(i);
                }
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
            else {
                result += str.charAt(i);
                map.put(str.charAt(i), 1);
            }
        }
        return result;
    }

}
