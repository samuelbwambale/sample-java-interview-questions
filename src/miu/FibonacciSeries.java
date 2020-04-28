package miu;

import java.util.HashMap;
import java.util.Map;

/*
 * In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc.
 * The first two numbers of fibonacci series are 0 and 1.
 */
public class FibonacciSeries {

    public static void main(String[] args) {
//        generateFibonacciSeries(8);
        System.out.println(generateFibonacci(9));
        System.out.println(generateFibonacciByRecursion(9));
        System.out.println(generateFibonacciWhileLoop(9));
        System.out.println(fibWithDynamicProg(9));
        System.out.println(fibRecursionWithMemoization(9));
    }

    static void generateFibonacciSeries(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(generateFibonacci(i) + ", ");
        }
    }
    static int generateFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int n0 = 0;
        int n1 = 1;
        int nextNumber = 0;
        for (int i = 2; i <= n; i++) {
            nextNumber = n0 + n1;
            n0 = n1;
            n1 = nextNumber;
        }
        return nextNumber;
    }
    
    /*
     * By recursion
     */
    
    static int generateFibonacciByRecursion(int n) {
    	if (n < 0) return -1;
    	if(n == 0 || n == 1) return n;
        return generateFibonacciByRecursion(n-1) + generateFibonacciByRecursion(n-2);
        }

    /*
     * With while loop
     */
    static int generateFibonacciWhileLoop(int n) {
        int num1 = 0, num2 = 1, sumOfPrevTwo = 0;

        int i=1;
        while(i<n)
        {
            sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
            i++;
        }
        return sumOfPrevTwo;
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

