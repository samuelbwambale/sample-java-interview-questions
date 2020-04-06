package miu;

/*Write a function that returns the difference of the sum of OddNumbers and sum of evenNumbers
*/
public class SumEvenOdd {
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 1 };
		int result = sumEvenOdd(a);
		System.out.println(result);
	}

	static int sumEvenOdd(int[] a) {
		int sumEven = 0;
		int sumOdd = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				sumEven += a[i];
			} else {
				sumOdd += a[i];
			}

		}
		return sumOdd - sumEven;
	}
}
