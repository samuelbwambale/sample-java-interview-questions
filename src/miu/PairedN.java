package miu;

import java.util.HashMap;

/*An array is defined to be paired-N if it contains two distinct elements that sum to N for 
* some specified value of N and the indexes of those elements also sum to N. 
* Write a function named isPairedN that returns 1 if its array parameter is a paired-N array. 
* The value of N is passed as the second parameter.
* 
* {1, 4, 1, 4, 5, 6}	n=5	returns 1	because a[2] + a[3] == 5 and 2+3==5. In other words, the sum of the values is equal to the sum of the corresponding indexes and both are equal to n (5 in this case).
	{1, 4, 1, 4, 5, 6}	n=6	returns 1	because a[2] + a[4] == 6 and 2+4==6
	{0, 1, 2, 3, 4, 5, 6, 7, 8}	n=6	returns 1	because a[1]+a[5]==6 and 1+5==6
	{8, -8, 8, 8, 7, 7, -7}	-15	0	because although a[1]+a[6]==-15, 1+6!=-15
	{3}	n=3	returns 0	because the array has only one element
	{}	n=0	returns 0	because the array has no elements
*/

public class PairedN {
	public static void main(String[] args) {
       
       int[] arr = {1, 0, 2, 3};
      int result = isPairedN(arr, 2);
    //    int result = isPairedN_Improved(arr, 2);
       System.out.println(result);
   }
	
	public static int isPairedN(int[] a, int n) {
		if(a==null || a.length < 2) {
			return 0;
			}

       for (int i = 0; i < a.length; i++) {
           for (int j = i + 1; j < a.length; j++) {
               if ((a[i] + a[j]) == n && a[i] != a[j]) {
                   return 1;
               }
           }
       }
       return 0;
   }
	
	public static int isPairedN_Improved(int[] a, int n) {
		if(a == null || a.length < 2) {
            return 0;
        }
        final Integer ONE = new Integer(1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++) {
            map.put(n - a[i], ONE);

        }
        for (int j = 0 ; j < a.length; j++) {
            if (map.containsKey(a[j]) && a[j] != (n - a[j])) {
                return 1;
            }
        }
        return 0;
   }

}

