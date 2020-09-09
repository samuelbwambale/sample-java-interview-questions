package miu;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "getting good at   coding needs a lot of practice";
        System.out.println(reverseWords(str)); // practice of lot a needs coding at good getting
    }

    static String reverseWords(String str) {
        String result = "";
        if(str.length() == 0 || str == null) return result;

        StringBuilder sb = new StringBuilder();
        String[] stringArray = str.split(" ");
        for (int i = stringArray.length - 1; i >= 0 ; i--) {
            sb.append(stringArray[i]);
            sb.append(" ");
        }

        result = sb.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
