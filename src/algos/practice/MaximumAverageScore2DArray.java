package algos.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumAverageScore2DArray {
    public static void main(String[] args) {
        String scores[][] = {
                {"Bob","80"},
                {"Charles","85"},
                {"Rob","70"},
                {"Bob","100"},
                {"Charles","75"}};
        System.out.println(getMaxAverageScore(scores));

    }

    static double getMaxAverageScore(String[][] scores) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < scores.length ; i++) {
            if(!map.containsKey(scores[i][0]))
                map.put(scores[i][0], new ArrayList<>());
            map.get(scores[i][0]).add(Integer.parseInt(scores[i][1]));

        }

        double maxAverage = 0;
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            double studentAverage = getStudentAverage(entry.getValue());
            maxAverage = maxAverage > studentAverage ? maxAverage : studentAverage;
        }

        return maxAverage;
    }

    static double getStudentAverage(List<Integer> list) {
        int sum = 0;
        for (Integer val: list) {
            sum += val;
        }

        return sum/list.size();
    }
}
