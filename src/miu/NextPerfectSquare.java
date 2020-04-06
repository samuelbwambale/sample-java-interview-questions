package miu;

/*
 * Function to return the next perfect square greater than given integer
*/

public class NextPerfectSquare {
	public static void main(String[] args) {
		int a = 30;
		int result = nextPerfectSquare(a);
		System.out.println(result);
	}

	static int nextPerfectSquare(int a) {
		if (a < 0)
			return 0;

		int root = (int) (Math.sqrt(a));
		int square = (root + 1) * (root + 1);
		return square;
	}
}
