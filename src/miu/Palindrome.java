package miu;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeString1("MADAM"));

        System.out.println(isPallindromeString2("MADAM"));

        System.out.println(isPallindromeString3("MADAM"));

        System.out.println(isPallindromeInt(34543));

    }

    /*
    Time complexity  O(n).
     */
    public static boolean isPalindromeString1(String str) {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters toc compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    /*
    Time complexity  O(n).
     */
    public static boolean isPallindromeInt(int number) {
        String reverse = "";
        String original = String.valueOf(number);
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            return true;
        else
            return false;
    }

    /*
    Time complexity  O(n).
     */
    public static boolean isPallindromeString2(String str) {
        String reverse = "";
        int length = str.length();
        for ( int i =0, j = length - 1; i < j; i++, j-- ) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }

        return true;
    }

    public static boolean isPallindromeString3(String str) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }

        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2 == 1) oddCount++;
        }

        if(oddCount > 1) return false;
        return true;
    }
}
