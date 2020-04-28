package miu;

import java.util.HashMap;
import java.util.Map;

public class FibonacciWithMemoization {

    public static void main(String[] args) {
        System.out.println(fibWithDynamicProg(8));
        System.out.println(fibRecursionWithMemoization(8));
    }

    static int fibWithDynamicProg(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    static int fibRecursionWithMemoization(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return calculateFib(cache, n);
    }
    static int calculateFib(Map<Integer, Integer> cache, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // already in memory
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // if not, calculate and memoize
        int result = calculateFib(cache, n - 1) + calculateFib(cache,n - 2);
        cache.put(n, result);
        return result;

    }
}
