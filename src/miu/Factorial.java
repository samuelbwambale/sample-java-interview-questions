package miu;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(factorial2(10));
    }

    static long factorial(int n) {
        if (n == 0) return 1;
        long accum = 1L;
        for (int i = 1; i <= n; i++) {
            accum *= i;
        }
        return accum;
    }

    static long factorial2(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        return n * factorial2(n - 1);
    }
}
