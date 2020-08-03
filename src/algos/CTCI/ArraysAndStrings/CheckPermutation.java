package algos.CTCI.ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {

    public static void main(String[] args) {

        System.out.println(checkPermutation2("abab", "aabb"));
        System.out.println(checkPermutation2("abcab", "aabb"));
        System.out.println();

        System.out.println(checkPermutation1("abab", "aabb"));
        System.out.println(checkPermutation1("abcab", "aabb"));
        System.out.println();
    }


    public static boolean checkPermutation1(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        // O(nlogn)
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for (int i = 0; i < charArray1.length; i++) {
            if(charArray1[i] != charArray2[i]) return false;
        }
        return true;
    }

    public static boolean checkPermutation2(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        return sortString(str1).equals(sortString(str2));
    }

    private static String sortString(String str) {
        char[] stringArray = str.toCharArray();
        Arrays.sort(stringArray);
        return new String(stringArray);
    }
}
