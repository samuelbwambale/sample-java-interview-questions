package algos.jimmy;

/*
3. A fat number is a positive integer which is equal to the sum of the factorials of its digits.

Recall that n factorial (written n!) = n * (n-1) * ... * 2 * 1, e.g. 5! = 5*4*3*2*1 = 120.

There are exactly four fat numbers that can be represented using 32 bits.

1 = 1!
2 = 2!
145 = 1! + 4! + 5! (1 + 24 + 120)
40585 = 4! + 0! + 5! + 8! + 5! (24 + 1 + 120 + 40,320 + 120)

The function below returns the number of fat numbers between 1 and 2,147,483,647
(the largest positive value that a 32 bit integer can take). It is correct,
but it could be more efficient. Notice that the factorial of each of the numbers 0 through 9 is computed many times.
For example if i=44444, the factorial of 4 would be computed 5 times.
It would be better to precompute the factorials of 0 through 9.
In this way the factorial function would be called only 10 times even though billions of digits are being processed.
Please modify the program to use precomputed factorials.

  static int countFatNumbers()
  {
    int count = 0;
    for (int i=1; i<=2147483647; i++)
    {
      int sum = 0;
      int j = i;

      // sum the factorials of each digit of j
      while (j > 0 && sum <= i)
      {
        sum += factorial(j%10);  // compute factorial of last digit of j and add it to sum
        j /= 10;  // shift j one place to the right
      }
      if (sum == i)  // if sum of digit factorials equals the number it is a fat number
        count++;
    }
    return count;
  }

  static int factorial(int n)
  {
    int fact = 1;
    for (int i = 2; i<=n; i++)
    {
      fact = fact * i;
    }

    return fact;
  }
 */
import java.util.HashMap;
import java.util.Map;

public class FatNumber {
    public static void main(String[] args) {
        System.out.println(countFatNumbers());

    }

    static int countFatNumbers()
    {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int fact = factorial(i);
            cache.put(i, fact);
        }

        int count = 0;
        for (int i=1; i<=2147483647; i++)
        {
            int sum = 0;
            int j = i;

            // sum the factorials of each digit of j
            while (j > 0 && sum <= i)
            {
                // get factorial(j%10) from the stored values in the cache
                sum += cache.get(j%10);  // compute factorial of last digit of j and add it to sum
                j /= 10;  // shift j one place to the right
            }
            if (sum == i)  // if sum of digit factorials equals the number it is a fat number
                count++;
        }
        return count;
    }

    static int factorial(int n)
    {

        int fact = 1;
        for (int i = 2; i<=n; i++)
        {
            fact = fact * i;
        }

        return fact;

    }
}
