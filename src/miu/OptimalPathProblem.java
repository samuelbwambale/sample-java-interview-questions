package miu;

import java.util.Arrays;

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */
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
