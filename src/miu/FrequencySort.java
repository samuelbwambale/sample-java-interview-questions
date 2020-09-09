package miu;

import java.util.*;

// Given a string, sort it in decreasing order based on the frequency of characters.
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("welcometoleetCodeco"));
        System.out.println("eeeeeooooccllttCdmw".equals(frequencySort("welcometoleetCodeco")));

        System.out.println();
        System.out.println(frequencySort2("welcometoleetCodec"));
        System.out.println("eeeeeoooccllttCdmw".equals(frequencySort2("welcometoleetCodec")));
    }

    // Time Complexity : O(nlogn) OR O(n+klogk).
    // Space Complexity : O(n)
    public static String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;

        // Create a sorted Array of chars.
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Convert identical chars into single Strings.
        List<String> charStrings = new ArrayList<String>();
        StringBuilder currentString = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {

            while(i+1 < chars.length && chars[i] == chars[i + 1]) {
                currentString.append(chars[i]);
                i++;
            }
            currentString.append(chars[i]);
            charStrings.add(currentString.toString());
            currentString = new StringBuilder();

        }

        // Our comparator is (a, b) -> b.length() - a.length().
        // If a is longer than b, then a negative number will be returned
        // telling the sort algorithm to place a first. Otherwise, a positive
        // number will be returned, telling it to place a second.
        // This results in a longest to shortest sorted list of the strings.
        Collections.sort(charStrings, (a, b) -> b.length() - a.length());

        // Use StringBuilder to build the String to return.
        StringBuilder sb = new StringBuilder();
        for (String str : charStrings) sb.append(str);
        return sb.toString();
    }

    // Time Complexity : O(nlogn) OR O(n+klogk).
    // Space Complexity : O(n)
    public static String frequencySort2(String s) {

        // Count up the occurances.
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
//            counts.put(c, counts.getOrDefault(c, 0) + 1);
            if(!counts.containsKey(c))
                counts.put(c, 0);
            counts.put(c, counts.get(c) + 1);
        }

        // Make a list of the keys, sorted by frequency.
        List<Character> characters = new ArrayList<>(counts.keySet());
        Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

        // Convert the counts into a string with a sb.
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int copies = counts.get(c);
            for (int i = 0; i < copies; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
