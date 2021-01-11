package miu;

/*

An array is said to be hollow if it contains 3 or more zeros in the middle
that are preceded and followed by the same number of non zero elements.
Write a function named isHollow that accepts an integer array and returns 1 if it is hollow array
Otherwise returns 0
 */

public class IsHollow {

    public static void main(String[] args) {

        IsHollow isHollowObj = new IsHollow();
        System.out.println(isHollowObj.isHollow(new int[] {1,2,4,0,0,0,0,3,4,5}));
        System.out.println(isHollowObj.isHollow(new int[] {1,2,0,0,0,3,4,5}));
        System.out.println(isHollowObj.isHollow(new int[] {1,2,4,9,0,0,0,3,4,5}));
        System.out.println(isHollowObj.isHollow(new int[] {1,2,0,0,4,5}));
        System.out.println(isHollowObj.isHollow(new int[] {1,0,4,0,0,0,3,3,5}));
        System.out.println(isHollowObj.isHollow(new int[] {0,0,0}));

    }

    int isHollow(int[] a) {

        if(a == null) return 0;
        int length = a.length;
        if(length < 3) return 0;

        int zeros = 0;
        int left = 0;
        int right = 0;

        int i;
        for (i = 0; i < length; i++) {
            if(a[i] != 0) left++;
            else break;
        }

        int j;
        for (j = i; j < length; j++) {
            if(a[j] == 0) zeros++;
            else break;
        }

        int k;
        for (k = j; k < length; k++) {
            if(a[k] == 0) return 0;
            right++;
        }

        if(left == right && zeros > 2) return 1;
        return 0;

    }


}
