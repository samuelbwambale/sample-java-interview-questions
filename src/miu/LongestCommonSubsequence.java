package miu;

/*
Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {

        System.out.println(getLongestSubSequence("ABCDGH","AEDFHR")); // result is 3
        System.out.println(getLongestSubSequence("AGGTAB","GXTXAYB")); // result is 4
    }

    public static int getLongestSubSequence(String str1, String str2) {

        char[] X=str1.toCharArray();
        char[] Y=str2.toCharArray();
        int m = X.length;
        int n = Y.length;

        return recursiveLCS( X, Y, m, n );

    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    private static int recursiveLCS( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + recursiveLCS(X, Y, m-1, n-1);
        else
            return Math.max(recursiveLCS(X, Y, m, n-1), recursiveLCS(X, Y, m-1, n));
    }

}
