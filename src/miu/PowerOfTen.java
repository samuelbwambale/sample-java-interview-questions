package miu;

public class PowerOfTen {
    public static void main(String[] args) {
        int val = 5;
        System.out.println(isPowerOfTen1(val));
        System.out.println(isPowerOfTen2(val));
        System.out.println(isPowerOfTen3(val));

    }

    public static boolean isPowerOfTen1(long n) {
        while(n > 0){
            if(n%10 != 0) return false;
            n /= 10;
        }
        return n == 0;
    }

    public static boolean isPowerOfTen2(long n) {
        return
                n == 1L
                        || n == 10L
                        || n == 100L
                        || n == 1000L
                        || n == 10000L
                        || n == 100000L
                        || n == 1000000L
                        || n == 10000000L
                        || n == 100000000L
                        || n == 1000000000L
                        || n == 10000000000L
                        || n == 100000000000L
                        || n == 1000000000000L
                        || n == 10000000000000L
                        || n == 100000000000000L
                        || n == 1000000000000000L
                        || n == 10000000000000000L
                        || n == 100000000000000000L
                        || n == 1000000000000000000L;
    }

    public static boolean isPowerOfTen3(int n){

        if( n == 1)
            return true;

        String num = String.valueOf(n);

        if(num.charAt(0) == '1' && Integer.parseInt(num.substring(1)) == 0)
            return true;
        else
            return false;
    }

}
