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
    // Avg case O(sqrt(n)/log(n))
    static int isPrime(int n) {
        if(n < 2){
            return 0;
        }
        for (int i = 2; i<= (int)Math.sqrt(n); i++) {
            if ((n % i) == 0) {
                return 0;
            }
        }
        return 1;
    }

    // Running time: o(n)
    public static int isPrime2(int n) {
        if(n < 2){
            return 0;
        }
        for(int i = 2; i < n; i++){
            if(n%i == 0){
                return 0;
            }
        }
        return 1;
    }

}
