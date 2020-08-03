package miu;

/*
Given a String, find the longest consecutive substring that contains only two unique characters.
Write the solution as a Java method, with the following signature:
  String longest2CharacterSubstring(String input)

For example:
    longest2CharacterSubstring("abcbbbbcccbdddadacb")
    should return "bcbbbbcccb"
 */

import java.util.*;

public class Longest2CharSubstring {

    public static void main(String[] args) {

        System.out.println(longest2CharacterSubstring("abcbbbbcccbdddadacb"));
        System.out.println(numberOfUniques(longest2CharacterSubstring("abcbbbbcccbdddadacb")));
    }
    

    public static int numberOfUniques(String str){
        if(str.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        String uniques = "";
        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
                uniques += str.charAt(i);
            }
        }
        return uniques.length();
    }


    public static String longest2CharacterSubstring(String str) {
        Map<String, Integer> substringsMap = new HashMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String tmp =  str.substring(i, j);
                if(numberOfUniques(tmp) == 2) {
                    substringsMap.put(tmp, tmp.length());
                }
            }
        }

        int max = 0;
        String result = "";
        for(Map.Entry<String, Integer> entry : substringsMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
