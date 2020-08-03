package miu;

public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(sumNumbers("ab22c4d"));
        System.out.println(sumNumbers(""));
    }

    public static int sumNumbers(String str) {
        int len = str.length();
        if(len == 0) return 0;

        int sum = 0;

        String temp = "";
        for (int i = 0; i < len; i++) {
            if(Character.isDigit(str.charAt(i))){
                String s = "" + str.charAt(i);
                if(Character.isDigit(str.charAt(i+1))){
                    temp += s;
                } else {
                    temp += s;
                    sum += Integer.parseInt(temp);
                    temp = "";
                }

            }
        }
        return sum;
    }
}
