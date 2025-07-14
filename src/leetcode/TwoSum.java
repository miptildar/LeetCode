package leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{3,3}, 6);
        System.out.println();
    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i=0; i<nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i=0; i<nums.length; i++) {
                int diff = target - nums[i];
                Integer diffIndex = map.get(diff);
                if (diffIndex != null && i != diffIndex) {
                    return new int[] {i, diffIndex.intValue()};
                }
            }

            return new int[0];
        }
    }

}
