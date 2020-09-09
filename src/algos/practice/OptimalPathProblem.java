package algos.practice;

import java.util.Arrays;

public class OptimalPathProblem {
    public static void main(String[] args) {
        int[][] test = new int[][] {
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}};
        System.out.println(getOptimalPath(test));

        System.out.println(getOptimalPath2(test));
    }

    static int getOptimalPath(int[][] inputArray) {
        int[][] myGrid = new int[inputArray.length][inputArray[0].length];
        int k = 0;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            myGrid[k++] = inputArray[i];
        }

        System.out.println("Inverted Input Array");
        for (int i = 0; i < myGrid.length; i++) {
            System.out.println(Arrays.toString(myGrid[i]));
        }

        int[][] result = new int[myGrid.length][myGrid[0].length];
        for (int row = 0; row < myGrid.length; row++) {
            for (int col = 0; col < myGrid[row].length; col++) {
                if(row == 0 && col == 0) {
                    result[row][col] = myGrid[row][col];
                }
                if(row == 0 && col > 0) {
                    result[row][col] = result[row][col - 1] + myGrid[row][col];
                }

                if(row > 0 && col == 0) {
                    result[row][col] = result[row - 1][col] + myGrid[row][col];
                }

                if(row > 0 && col > 0) {
                    result[row][col] = Math.max(result[row - 1][col], result[row][col - 1]) + myGrid[row][col];
                }
            }
        }

        System.out.println("Result");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        return result[result.length - 1][result[0].length -1];
    }

    static int getOptimalPath2(int[][] inputArray) {


        int[][] result = new int[inputArray.length][inputArray[0].length];
        for (int row = inputArray.length - 1; row >= 0; row--) {
            for (int col = 0; col < inputArray[row].length; col++) {
                if(row == inputArray.length - 1 && col == 0) {
                    result[row][col] = inputArray[row][col];
                }
                if(row == inputArray.length - 1 && col > 0) {
                    result[row][col] = result[row][col - 1] + inputArray[row][col];
                }

                if(row < inputArray.length - 1 && col == 0) {
                    result[row][col] = result[row + 1][col] + inputArray[row][col];
                }

                if(row < inputArray.length - 1 && col > 0) {
                    result[row][col] = Math.max(result[row + 1][col], result[row][col - 1]) + inputArray[row][col];
                }
            }
        }

        System.out.println("Result");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        return result[0][result[0].length -1];
    }
}
