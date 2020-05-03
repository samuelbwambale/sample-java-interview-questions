package miu;

public class GCD_GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcd(60, 36));
    }

    /*
    Valid Recursion. Base case is n = 0. Successive self-calls reduce
    the second input argument, leading to the base case.
    Base Case is correct. It is true that gcd(m,0) = m.

    The running time of GCD(m,n) in terms of its input values m, n is
    O(log n). In terms of its input sizes, its running time is O(length(n)).

     */


    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
