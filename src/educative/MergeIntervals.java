package educative;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        mergeIntervals(new int[][]{{4,6},{3,7},{1,5}});
    }

    public static int[][] mergeIntervals(int[][] intervals) {

        List<int[]> arrayList = Arrays.asList(intervals);
        arrayList.sort((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            }  else if (o1[0] < o2[0]) {
                return -1;
            }
            return 0;
        });

        List<int[]> result = new ArrayList<>();

        int right = 1;
        int resultIndex = 0;
        result.add(intervals[0]);

        while (right < intervals.length) {
            int[] leftInterval = result.get(resultIndex);
            int[] rightInterval = intervals[right];

            // fully within
            if (leftInterval[1] >= rightInterval[1]) {
                right++;
                continue;
            }

            // intersection
            if (leftInterval[1] >= rightInterval[0]) {
                result.get(resultIndex)[1] = rightInterval[1];
                right++;
                continue;
            }

            // no intersection
            if (leftInterval[1] < rightInterval[0]) {
                resultIndex++;
                result.add(rightInterval);
                right++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
