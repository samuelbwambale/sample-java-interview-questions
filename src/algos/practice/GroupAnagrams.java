package algos.practice;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("art");
        strings.add("cheese");
        strings.add("cat");
        strings.add("rat");
        strings.add("tar");
        strings.add("act");
        strings.add("tca");

        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(List<String> strings) {
        List<List<String>> result = new ArrayList<>();
        if(strings.size() == 0) return result;

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedString = Arrays.toString(strArray);

            if(!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());
            map.get(sortedString).add(str);

        }


//        for(Map.Entry<String, List<String>> entry : map.entrySet()){
//            result.add(entry.getValue());
//        }

        return new ArrayList<>(map.values());

    }
}
