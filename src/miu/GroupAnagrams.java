package miu;

import java.util.*;
/*
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings1 = {"eat","tea","tan","ate","nat","bat"};
        String[] strings2 = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        System.out.println(groupAnagrams(strings1));

        System.out.println();
        System.out.println(groupAnagrams(strings2));
        System.out.println(groupAnagrams2(strings2));
    }

    /*
    Time Complexity: O(NKlogK),
    where NN is the length of strs, and KK is the maximum length of a string in strs.

    Space Complexity: O(NK), the total information content stored in map
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0) return new ArrayList();

        Map<String, List<String>> map = new HashMap();

        for(String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
//            String sortedString = new String(array);
            String sortedString = Arrays.toString(array);

            if(!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }

        List<List<String>> solution = new ArrayList<>();
        map.values().stream().forEach(list -> solution.add(list));
        return solution;

        // return new ArrayList(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {

        if(strs.length == 0) return new ArrayList();

        Map<Integer, List<String>> map = new HashMap();

        for(int i = 0; i < strs.length; i++) {
            int numericValue = getStringNumericValue(strs[i]);


            if(!map.containsKey(numericValue))
                map.put(numericValue, new ArrayList<String>());
            map.get(numericValue).add(strs[i]);
        }

        return new ArrayList(map.values());

    }

    private static int getStringNumericValue(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += (int)c;
        }
        return sum;
    }
}
