package miu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumAverageScore2DArray {
    public static void main(String[] args) {
        String scores[][] = {{"Bob","80"}, {"Charles","85"}, {"Rob","70"},{"Bob","100"}, {"Charles","75"}};
        System.out.println(getMaxAverageScore(scores));

        System.out.println();
        populateChangeCalculateTotalAndAverageScore(5,4);
    }

    public static int getMaxAverageScore(String[][] scores) {
        if (scores == null)
            return -1;

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            if(!map.containsKey(scores[i][0])){
                map.put(scores[i][0], new ArrayList<Integer>());
            }
            map.get(scores[i][0]).add(Integer.parseInt(scores[i][1]));
        }

        int maxAverage = 0;
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int averageScoreOfStudent = getAverageScoreOfStudent(entry.getValue());
            maxAverage = maxAverage > averageScoreOfStudent ? maxAverage : averageScoreOfStudent;

        }
        return maxAverage;
    }

    private static int getAverageScoreOfStudent(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum/list.size();
    }

    public static void populateChangeCalculateTotalAndAverageScore(int numOfStudents, int numOfTests) {
        /*
            * Declare a 2 - Dimensional Array that represents N students each with M number of test scores
            * Assign 100 for all tests to all students
            * Change the 3rd student's test 2 to 50
            * Change the last student's last test to 87
            * Print out all test scores
            * Caclulate the total points of all students and the total average
            * Caclulate the total points for each student and their average
         */

        // Declare a 2 - Dimensional Array that represents N students each with M number of test scores
        double[][] testScores = new double[numOfStudents][numOfTests];

        // Assign 100 for all tests to all students
        for (int i = 0; i < testScores.length; i++) {
            for (int j = 0; j < testScores[i].length; j++) {
                testScores[i][j] = 100;
            }
        }

        // Print the scores
        for (int i = 0; i < testScores.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for (int j = 0; j < testScores[i].length; j++) {
                System.out.print(testScores[i][j] + " ");
            }
            System.out.println();
        }

        // Change the 3rd student's test 2 to 50
        // Change the last student's last test to 87
        testScores[2][1] = 50;
        testScores[numOfStudents-1][numOfTests-1] = 87;


        // Print the scores again
        System.out.println();
        for (int i = 0; i < testScores.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for (int j = 0; j < testScores[i].length; j++) {
                System.out.print(testScores[i][j] + " ");
            }
            System.out.println();
        }

        // Caclulate the total points of all students and the total average
        double totalScoreForAllStudents = 0;
        for (int i = 0; i < testScores.length; i++) {
            for (int j = 0; j < testScores[i].length; j++) {
                totalScoreForAllStudents += testScores[i][j];
            }
        }
        System.out.println();
        System.out.println("Total Score For All Students = " + totalScoreForAllStudents);
        System.out.println("Total Average Score For All Students = " + totalScoreForAllStudents / (numOfStudents * numOfTests));

        // Caclulate the total points for each student and their average
        System.out.println();
        for (int i = 0; i < testScores.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            double totalScore = 0;
            for (int j = 0; j < testScores[i].length; j++) {
                totalScore += testScores[i][j];
            }
            System.out.print("Total Score = " + totalScore + ", Average Score = " + totalScore/numOfTests);
            System.out.println();
        }
    }
}
