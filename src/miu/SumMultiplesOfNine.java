package miu;

/*Sum all the multiples of 9 in an array
*/
public class SumMultiplesOfNine {
	public static void main(String[] args) {
		int[] a = { 0, 1, 9, 18 };
		int result = f(a);
		System.out.println(result);

	}

	static int f(int[] y) {
		int sum = 0;
		for (int i = 0; i < y.length; i++) {
			if (y[i] % 9 == 0) {
				sum += y[i];
			}
		}
		return sum;
	}
}
