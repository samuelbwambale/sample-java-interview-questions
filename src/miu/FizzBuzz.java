package miu;

/*
 * 
Write a program that prints the numbers from 1 to integer N.
But for multiples of three print “Fizz” instead of the number 
and for the multiples of five print “Buzz”.
For numbers which are multiples of both three and five print “FizzBuzz”
*
*/

import java.util.stream.IntStream;

public class FizzBuzz {
	public static void main(String[] args) {
		fizzBuzz2(100);
	}
	
	static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.print("FizzBuzz" + " ");
				} else
					System.out.print("Fizz" + " ");
			} else if (i % 5 == 0) {
				System.out.print("Buzz" + " ");
			} else
				System.out.print(i + " ");
		}
	}

	public static void fizzBuzz2(int n) {
		IntStream.rangeClosed(1,n)
				.mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
				.forEach(System.out::println);
	}
}
