package miu;

/*
Given a positive integer, check if the number is prime or not.
A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself.
*/
public class IsPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime2(1));
    }

    /*
    If a number n is not a prime, it can be factored into two factors a and b:
    n = a * b
    Both of those numbers need to be 2 or larger, so it doesn't make any sense to check numbers larger than n/2,
    they couldn't possibly divide evenly.

    Even better if we consider the sqrt(n). If both a and b were greater than the sqrt(n),
    then a * b would be greater than n. So at least one of those factors must be less than or equal to the square root of n,
    and if we can't find any factors less than or equal to the square root, n must be prime.
    Because if a is larger than sqrt(n) then b must be smaller, and you'd have already checked it.
     */

    // Worst case O(sqrt(n))
    static int isPrime(int n) {
        if(n < 2){
            return 0;
        }

        if (n <= 3)
            return 1;

        for (int i = 2; i<= (int)Math.sqrt(n); i++) {
            if ((n % i) == 0) {
                return 0;
            }
        }
        return 1;
    }

    // Worst case O(sqrt(n))
    static boolean isPrimeImproved(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Running time: o(n)
    public static int isPrime2(int n) {
        if(n <= 1){
            return 0;
        }

        if (n == 2 || n == 3) return 1;

        for(int i = 2; i < n; i++){
            if(n%i == 0){
                return 0;
            }
        }
        return 1;
    }

}
