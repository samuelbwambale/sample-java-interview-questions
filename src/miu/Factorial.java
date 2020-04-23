package miu;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    static long factorial(int n) {
        if (n == 0) return 1;
        long accum = 1L;
        for (int i = 1; i <= n; i++) {
            accum *= i;
        }
        return accum;
    }
}
