package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int length = new Solution().lengthOfLongestSubstring("aab");
        System.out.println();

    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {

            // char => position
            Map<Character, Integer> map = new HashMap<>();
            int currentMax = 0;
            for (int low = 0, high = 0; high < s.length(); high++) {
                char currentChar = s.charAt(high);
                if (map.containsKey(currentChar)) {
                    Integer position = map.get(currentChar);
                    removeInRange(map, s, low, position);
                    low = position + 1;
                    map.put(currentChar, high);
                    continue;
                }

                map.put(currentChar, high);
                if (map.size() > currentMax)
                    currentMax = map.size();
            }

            return currentMax;
        }

        private void removeInRange(Map<Character, Integer> map, String s, int start, int end) {
            for (int i = start; i <= end; i++) {
                map.remove(s.charAt(i));
            }
        }
    }

}
