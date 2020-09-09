package miu;

/*
 * Funtion that returns the number of primes between `start` and `end` inclusive
Recall a prime number is a +ve integer greater than 1 whose only factors are 1 and itself
*/
public class PrimeCount {
	public static void main(String[] args) {
		int q = 1;
		int r = 48;
		System.out.println(primeCount(q, r));
		System.out.println(primeCount2(q, r));
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

	static int primeCount2(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			if(i > 1 && isPrime(i)) count++;
		}
		return count;
	}

	static boolean isPrime(int n) {
		if(n <= 1) return false;

		if(n == 2 || n == 3) return true;

		for (int i = 2; i*i <=n ; i++) {
			if(n%i == 0) return false;
		}

		return true;
	}
}
