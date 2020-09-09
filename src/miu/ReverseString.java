package miu;

public class ReverseString {
    public static void main(String[] args) {
        String str = "love";
        System.out.println(reverseString1(str));
        System.out.println(reverseString2(str));
        System.out.println(reverseString3(str));
    }

    public static String reverseString1(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    public static String reverseString2(String str) {
        String result = "";
        for (int i = str.length() - 1; i >=0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public static String reverseString3(String str) {
        String result = "";
        char[] array = str.toCharArray();
        for (int i = array.length - 1; i >=0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
