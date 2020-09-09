package miu;


/*
 * Implement a run length encoding function.
 *
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaa" -> "a2b3a2"
 * ""      -> ""
 */
public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "aabbbbccck";
        System.out.println(runLengthEncoding(str));
        System.out.println(encodeString(str));
    }

    public static String runLengthEncoding(String text) {
        String encodedString = "";

        for (int i = 0, count = 1; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1))
                count++;
            else {
                encodedString = encodedString.concat(Character.toString(text.charAt(i))).concat(Integer.toString(count));
                count = 1;
            }
        }
        return encodedString;
    }

    public static String encodeString(String str) {
        String result = "";
        int count = 1;
        for(int i = 0; i < str.length(); i++) {
            while(i < str.length() -1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
                // System.out.println(count);
                // System.out.println(i);

            }
            result += Character.toString(str.charAt(i));
            result += Integer.toString(count);
            count = 1;
        }

        return result;
    }

}
