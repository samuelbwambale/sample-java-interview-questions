package algos.practice;

public class RunLengthEncoding {
    public static void main(String[] args) {
        System.out.println(runLengthEncode("aabbbccd"));
        System.out.println(runLengthEncodeMaxLen("aabbbccd"));
    }

    public static String runLengthEncode(String str) {
        int len = str.length();
        if(len == 0 || str == null) return str;
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < len; i++) {
            while (i+1 < len && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(str.charAt(i));
            result.append(count);
            count = 1;

        }

        return result.toString();
    }

    public static String runLengthEncodeMaxLen(String str) {
        int len = str.length();
        if(len == 0 || str == null) return str;
        String result = "";
        int count = 1;
        char maxChar = str.charAt(0);
        int startIndex = 0;
        int maxCount = 1;

        for (int i = 0; i < len; i++) {
            while (i+1 < len && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            if(maxCount < count) {

                maxChar = str.charAt(i);
                maxCount = count;
                startIndex = i - count + 1;

            }
            count = 1;

        }

        result += maxChar;
        result += startIndex;
        result += maxCount;
        return result;
    }
}
