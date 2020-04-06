package miu;

/*
 * Funtion that returns the number of primes between `start` and `end` inclusive
Recall a prime number is a +ve integer greater than 1 whose only factors are 1 and itself
*/
public class PrimeCount {
	public static void main(String[] args) {
		int q = -10;
		int r = -190;
		int result = primeCount(q, r);
		System.out.println(result);
	}

	static int primeCount(int a, int b) {
		int result = 0;
		if ((a < 0) && (b < 0))
			return result;
		for (int i = a; i <= b; i++) {
			if (i > 1) {
				boolean isPrime = true;
				for (int j = 2; j * 2 <= i; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					result++;
				}
			}
		}
		return result;

	}
}
