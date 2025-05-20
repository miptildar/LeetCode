package educative;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        leastInterval(new char[]{'A', 'B', 'C', 'O', 'Q', 'C', 'Z', 'O', 'X', 'C', 'W', 'Q', 'Z', 'B', 'M', 'N', 'R', 'L', 'C', 'J'}, 10);
    }

    public static int leastInterval(char[] tasks, int n) {

        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> {
            if (entry1.getValue() > entry2.getValue()) {
                return -1;
            } else if (entry1.getValue() < entry2.getValue()) {
                return 1;
            }
            return 0;
        });


        int maxIndex = 0;

        return maxIndex;
    }

//    static NextPositionResult getNextPosition(int currentPosition,
//                                              int remainingTasks,
//                                              int gapSize,
//                                              int firstIntervalIndex,
//                                              int numberOfIntervals) {
//        int x = currentPosition + gapSize + 1;
//    }

    static class NextPositionResult {
        int nextPosition;
        int firstIntervalIndex;
        int numberOfIntervals;
    }
}
