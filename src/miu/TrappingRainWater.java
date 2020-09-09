package miu;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWaterBruteforce(height));
        System.out.println(trappingRainWaterDP(height));
    }

    public static int trappingRainWaterBruteforce(int[] height) {
        if(height == null || height.length == 0) return 0;
        int totalTrappedWater = 0;
        for(int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            int rightMax = height[i];
            for(int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for(int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int waterLevel = Math.min(leftMax, rightMax);
            int trappedWaterAtIndexI = waterLevel - height[i];
            totalTrappedWater += trappedWaterAtIndexI;

        }

        return totalTrappedWater;

    }

    public static int trappingRainWaterDP(int[] height) {
         if(height == null || height.length == 0) return 0;
         int totalTrappedWater = 0;


         int currentLeftMax = height[0];
         int[] leftMaximums = new int[height.length];
         leftMaximums[0] = currentLeftMax;
         for(int i = 1; i < height.length; i++) {
             currentLeftMax = Math.max(currentLeftMax, height[i]);
             leftMaximums[i] = currentLeftMax;

         }

         int currentRightMax = height[height.length - 1];
         int[] rightMaximums = new int[height.length];
         rightMaximums[height.length - 1] = currentRightMax;
         for(int i = height.length - 2; i >= 0; i--) {
             currentRightMax = Math.max(currentRightMax, height[i]);
             rightMaximums[i] = currentRightMax;

         }

         for(int i = 0; i < height.length; i++) {
             int waterLevel = Math.min(leftMaximums[i], rightMaximums[i]);
             int trappedWaterAtIndexI = waterLevel - height[i];
             totalTrappedWater += trappedWaterAtIndexI;

         }

         return totalTrappedWater;
    }
}
