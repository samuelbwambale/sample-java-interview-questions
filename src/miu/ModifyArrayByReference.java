package miu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifyArrayByReference {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] a = {1,2,3};
        list.add(a);
        list.forEach(x->System.out.println(Arrays.toString(x)));
        a[0] = 4;
        a[1] = 5;
        a[2] = 6;
        list.forEach(x->System.out.println(Arrays.toString(x)));
    }
}
