package miu;

public class IsPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(13));
    }

    static int isPrime(int n) {
        for (int x = 2; x<= (int)Math.sqrt(n); x++) {
            if ((n % x) == 0) {
                return 0;
            }
        }
        return 1;
    }
}
