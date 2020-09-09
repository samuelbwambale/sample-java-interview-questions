package miu;

// A function to print all prime factors
// of a given number n

/*
While n is divisible by 2, print 2 and divide n by 2.
After step 1, n must be odd. Now start a loop from i = 3 to square root of n.
While i divides n, print i and divide n by i, increment i by 2 and continue.
If n is a prime number and is greater than 2, then n will not become 1 by above two steps.
So print n if it is greater than 2.
 */


import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static void main(String[] args) {
        int n = 26;
        primeFactorization(n);

        System.out.println();
        System.out.println(primeFactor(n));
    }

    public static void primeFactorization(int number) {

        // Print the number of 2s that divide n
        while(number % 2 == 0) {
            System.out.print(2 + " ");
            number /= 2;
        }

        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i*i <= number; i += 2) {
            while(number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (number > 2)
            System.out.print(number);


    }

    public static List<Integer> primeFactor(Integer n){
        Integer i =2;
        List<Integer>list = new ArrayList<>();
        while (i<=n){
            if(n%i==0){
                list.add(i);
                n/=i;
            }
            else i++;
        }
        return list;
    }
}
