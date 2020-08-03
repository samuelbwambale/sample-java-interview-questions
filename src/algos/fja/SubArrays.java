package algos.fja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        generateSubArrays(Arrays.asList(1,2,3));
    }

    public static void generateSubArrays(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < arr.size(); j++) {
                temp.add(arr.get(j));
                System.out.println(temp);
            }

        }
    }

    public static void longestSubArraySumsToK(List<Integer> arr, int k) {
        int len = 0;
        List<Integer> solution;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for (int j = i; j < arr.size(); j++) {
                temp.add(arr.get(j));
                sum += arr.get(j);
                System.out.println(temp);
                if(sum <= k && temp.size() > len) {
                    solution = temp;
                    len = temp.size();
                }
            }

        }
    }
}
