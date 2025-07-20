package leetcode.dyn_programming;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        int[] mas = new int[len];
        Arrays.fill(mas, Integer.MAX_VALUE);

        mas[0] = cost[0];
        mas[1] = cost[1];

        for (int i=0; i < len; i++) {
            int current = mas[i];

            if (i + 1 < len) {
                int x = current + cost[i + 1];
                if (x < mas[i+1]) mas[i + 1] = x;
            }

            if (i + 2 < len) {
                int x = current + cost[i + 2];
                if (x < mas[i + 2]) mas[i + 2] = x;
            }
        }

        return Math.min(mas[len - 1], mas[len - 2]);
    }

}
