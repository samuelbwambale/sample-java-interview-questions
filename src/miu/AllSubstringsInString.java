package miu;

import java.util.*;

public class AllSubstringsInString {
    public static void main(String[] args) {
        allPossibleSubstrings("abdd");
        System.out.println(allPossibleUniqueSubstrings("abdd"));
    }

    public static void allPossibleSubstrings(String str) {

        int len = str.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String tmp = str.substring(i, j);
                System.out.println(tmp);
            }
//            for (int j = len; j > i; j--) {
//                String tmp = str.substring(i, j);
//                System.out.println(tmp);
//            }
        }
    }

    public static List<String> allPossibleUniqueSubstrings(String str) {
        List<String> result = new ArrayList<>();
        int len = str.length();
        if(len == 0 || str == null) return result;


        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = len; j > i; j--) {
                String tmp = str.substring(i, j);
                if(!set.contains(tmp)) {
                    set.add(tmp);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
