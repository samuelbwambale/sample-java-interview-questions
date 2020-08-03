package miu;

import java.util.HashMap;
import java.util.Map;

public class AllSubstringsInString {
    public static void main(String[] args) {
        allPossibleSubstrings("abcd");
    }

    public static void allPossibleSubstrings(String str) {

        int len = str.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String tmp = str.substring(i, j);
                System.out.println(tmp);
            }
        }
    }
}
