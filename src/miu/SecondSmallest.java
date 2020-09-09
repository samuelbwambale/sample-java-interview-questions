package miu;

public class SecondSmallest {
    public static void main(String[] args) throws Exception {
        System.out.println(secondSmallest(new int[] {12, 13, 1, 10, 34, 1})); // 10
    }

    public static int secondSmallest(int[] arr) throws Exception {
        if(arr.length < 2) throw new Exception("Array has less than two elements");
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }

            if(arr[i] > smallest && arr[i] < secondSmallest)
                secondSmallest = arr[i];

//            if(arr[i] < secondSmallest && arr[i] != smallest)
//                secondSmallest = arr[i];
        }

        if(secondSmallest == Integer.MAX_VALUE) throw new Exception("No second smallest found");
        return secondSmallest;
    }
}
