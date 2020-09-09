package miu;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) throws Exception {
        String str = "aabbccddf";
        System.out.println(firstNonRepeatingChar(str));
    }

    public static char firstNonRepeatingChar(String str) throws Exception {
        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i),map.get(str.charAt(i)) + 1 );
        }

        for (int i = 0; i < len; i++) {
            if(map.get(str.charAt(i)) == 1)
                return str.charAt(i);
        }

        throw new Exception("No non-repeating character found");
    }
}
