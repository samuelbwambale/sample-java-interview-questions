package miu;

// https://ideone.com/OWJ70I
/* package whatever; // don't place package name! */

public class PermutationsWithReplacementString
{
    public static void main (String[] args) throws Exception
    {
        String str = "ABC";
        char[] perm = new char[3];
        permutation(perm, 0, str);

    }

    private static void permutation(char[] perm, int pos, String str) {
        if (pos == perm.length) {
            System.out.println(new String(perm));
        } else {
            for (int i = 0 ; i < str.length() ; i++) {
                perm[pos] = str.charAt(i);
                permutation(perm, pos+1, str);
            }
        }
    }


}
