package algos.CTCI.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Determine if a string has all unique characters
 */
public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("abcd"));
        System.out.println(isUnique("abcdd"));
        System.out.println();

        System.out.println(isUnique2("abcd"));
        System.out.println(isUnique2("abcdd"));
        System.out.println();

        System.out.println(isUnique3("abcd"));
        System.out.println(isUnique3("abcdd"));
    }

    public static boolean isUnique(String str) {
        int len = str.length();
        if(len == 0) return true;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else return false;
        }
        return true;
    }

    public static boolean isUnique2(String str)
    {
        char[] chArray = str.toCharArray();

        // O(nlogn) time complexity
        Arrays.sort(chArray);

        for (int i = 0; i < chArray.length - 1; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chArray[i] != chArray[i + 1])
                continue;

                // if at any time, 2 adjacent elements
                // become equal, return false
            else
                return false;
        }
        return true;
    }
    // Need to be sure if the string is ASCII or Unicode. I will assume the character set is ASCII
    public static boolean isUnique3(String str) {
        int len = str.length();
        if(len == 0) return true;
        if(len > 128) return false;

        boolean[] char_set = new boolean[128];

        System.out.println("char_set at 0 " + char_set[0]);
        for (int i = 0; i < len; i++) {
            // Get ASCII value
            int val = str.charAt(i);
            if(char_set[val]) { //Already found
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
