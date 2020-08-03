package algos.CTCI.ArraysAndStrings;

public class ReplaceSpaces {
    public static void main(String[] args) {
        System.out.println(countOfWhiteSpaces("ab  c "));
        System.out.println(replaceSpaces("ab  c "));
        System.out.println(replaceSpaces("Mr John    Smith"));

        String s = replaceSpaces("Mr John    Smith");


//        System.out.println(countOfWhiteSpaces(replaceSpaces("Mr John    Smith")));
    }

    public static String replaceSpaces(String str) {
        int spaces = countOfWhiteSpaces(str);
        char[] charArray = str.toCharArray();

        char[] a = manipulate(charArray, spaces);
        String replacedString = "";
        for (int i = 0; i < a.length; i++) {
            if(a[i] != '\0') replacedString += a[i];
        }

        return replacedString;
    }

    public static char[] manipulate(char[] array, int spaces) {
        char[] result = new char[array.length + spaces * 2];
        System.out.println(result.length);
        int y = 3;
        for (int i = 0, j = 0; i < array.length && j < result.length; i++) {
            if(array[i] == ' ') {
                if(i < array.length - 1 && array[i + 1] != ' ') {
                    result[j] = '%';
                    result[j+1] = '2';
                    result[j+2] = '0';
                    j = j +3;
                } else continue;
            } else {
                result[j] = array[i];
                j++;
            }

        }


        return result;
    }

    static int countOfWhiteSpaces(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == ' ' && str.charAt(i+1) != ' ') {
                count++;
            }
        }
        return count;
    }
}
