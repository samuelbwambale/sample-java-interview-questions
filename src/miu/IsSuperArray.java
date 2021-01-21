package miu;

/*
A super array is defined to be an array in which each element is greater than
the sum of all the elements before that.

{2,3,6,13} is a super array
{2,3,5,11} is not a super array
 */

public class IsSuperArray {

    public static void main(String[] args) {
        IsSuperArray isSuperArrayObj = new IsSuperArray();
        System.out.println(isSuperArrayObj.isSuper(new int[] {2,3,6,13}));
        System.out.println(isSuperArrayObj.isSuper(new int[] {2,3,5,11}));
        System.out.println(isSuperArrayObj.isSuper(new int[] {2}));

    }

    int isSuper(int[] a) {
        if (a == null) return 0;

        int length = a.length;
        if(length < 2) return 1;

        int sum = a[0];
        for (int i = 1; i < length; i++) {
            if(a[i] <= sum) return 0;
            sum += a[i];
        }
        return 1;

    }

}
