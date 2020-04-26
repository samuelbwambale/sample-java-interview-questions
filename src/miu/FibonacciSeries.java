package miu;

/*
 * In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc.
 * The first two numbers of fibonacci series are 0 and 1.
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        generateFibonacciSeries(8);
    }

    static void generateFibonacciSeries(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(generateFibonacci(i) + ", ");
        }
    }
    static int generateFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else {
            int n0 = 0;
            int n1 = 1;
            int nextNumber = 0;
            for (int i = 2; i <= n; i++) {
                nextNumber = n0 + n1;
                n0 = n1;
                n1 = nextNumber;
            }
            return nextNumber;

        }

    }
    
    /*
     * By recursion
     */
    
    static int generateFibonacciByRecursion(int n) {
    	if (n < 0) return -1;
    	if(n == 0 || n == 1) return n;
        return generateFibonacciByRecursion(n-1) + generateFibonacciByRecursion(n-2);
        }

    /*
     * With while loop
     */
    static int n1=0, n2=1, n3=0;
    static void generateFibonacciWhileLoop(int n) {
        while(n>0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            generateFibonacciByRecursion(n-1);
        }

    }
}

