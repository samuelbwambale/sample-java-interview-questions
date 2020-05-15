package miu;

/*
    https://www.geeksforgeeks.org/time-complexity-permutations-string/
 */
public class PermutationString {
    public static void main(String[] args) {
        perm("ABC");

        System.out.println();
        System.out.println(count);

    }
    static int count = 0;

    /*
        Total runtime
        Calling perm O(n * n!) times (as an upper bound) and each call takes O(n) time,
        the total runtime will not exceed O(n^2 * n!)
     */
    static void perm(String str){
        perm(str, "");
    }

    static void perm(String str, String prefix){
        count++;
        if(str.length() == 0){
            System.out.println(prefix);
            } else{
            for(int i = 0; i < str.length(); i++){
                String reminder = str.substring(0, i) +
                        str.substring(i + 1);
                        perm(reminder, prefix + str.charAt(i));
                       }
                }
        }
}
