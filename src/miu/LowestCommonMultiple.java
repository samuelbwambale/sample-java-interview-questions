package miu;

/*Given two positive integers x, y, find the smallest positive integer z with the property
that both x and y are factors of z.
*/

public class LowestCommonMultiple {
    public static void main(String[] args) {
        System.out.println(smallestCommon(7, 14));
        System.out.println(smallestCommon_Improved(7, 14));
    }

    public static int smallestCommon(int x, int y) {
        int product = x * y;
        for (int i = 1; i < product; i++) {
            if(i % x == 0 && i % y == 0) {
                return i;
            }
        }
        return product;
    }
    
    /*
     * Using recursive approach
     */
    
    static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    static int smallestCommon_Improved(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    }
    
}

