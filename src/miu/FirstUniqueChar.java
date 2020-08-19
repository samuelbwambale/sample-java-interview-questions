package miu;

/*
How to find the first (in terms of occurrence in input, not lexicographically)
non-repeated character of a given String?
Write the solution as a Java method, with the following signature:
  Character firstUniqueChar(String input)

For example:
  firstUniqueChar("find first non repeated character of a given String")
should return:
  ‘s
 */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String str = "vavalu";
        System.out.println(firstNonRepeatedCharacter(str));
        String left = str.substring(0,2);
        String right = str.substring(2+1);
        System.out.println(left);
        System.out.println(right);

        System.out.println();
        System.out.println(firstUniqueCharacter2(str));

    }

    /* *
    Using HashMap to find first non-repeated character from String in Java.
        * Algorithm :
            * Step 1 : Scan String and store count of each character in HashMap
            * Step 2 : traverse String and get count for each character from Map.
            * Since we are going through String from first to last character,
            * when count for any character is 1, we break, it's the first
            * non repeated character. Here order is achieved by going
            * through String again.

            Time complexity : O(N) since we go through the string of length N two times.
            Space complexity : O(1) because English alphabet contains 26 letters.

          */

    public static char firstNonRepeatedCharacter(String word) {
        Map<Character, Integer> map = new HashMap<>();
        // build table [char -> count]
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // since HashMap doesn't maintain order, going through string again
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return 'X';
    }

    private static char firstUniqueCharacter2(String str) {
        int len = str.length();
        if(len == 1) return str.charAt(0);

        for (int i = 0; i < len; i++) {
            if(i == 0) {
                String substring = str.substring(1);
                if(substring.indexOf(str.charAt(i)) == -1) return str.charAt(i);
            }
            if(i < len -1) {
                String left = str.substring(0,i);
                String right = str.substring(i+1);
                if(left.indexOf(str.charAt(i)) == -1 && right.indexOf(str.charAt(i)) == -1)
                    return str.charAt(i);
            }
            if(i == len-1) {
                String substring = str.substring(0,len-1);
                if(substring.indexOf(str.charAt(len-1)) == -1)
                    return str.charAt(len-1);

            }

        }
        return 'x';

    }


}
