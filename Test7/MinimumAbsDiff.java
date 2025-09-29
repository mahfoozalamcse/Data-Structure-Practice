package Test7;

import java.util.Collections;
import java.util.List;

public class MinimumAbsDiff {
    // Minimum Absolute Difference in an Array
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int minAbs = Integer.MAX_VALUE;

        for (int i = 1; i < arr.size(); i++) {

            int min = Math.abs(arr.get(i) - arr.get(i - 1));

            if (min < minAbs) {
                minAbs = min;
            }
        }

        return minAbs;
    }

    public static void main(String[] args) {

    }
}
