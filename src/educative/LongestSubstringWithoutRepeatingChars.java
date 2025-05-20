package educative;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("abcdbea"));
    }

    public static int findLongestSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;
        int right = 1;

        map.put(str.charAt(left), left);

        while (right < str.length()) {
            char rightChar = str.charAt(right);
            if (map.containsKey(rightChar)) {

                if (map.size() > max) {
                    max = map.size();
                }

                char[] charsToRemove = str.substring(left, map.get(rightChar)).toCharArray();
                for (char c : charsToRemove) {
                    map.remove(c);
                }

                left = map.get(rightChar) + 1;
                map.put(rightChar, right);

                right++;
                continue;
            }

            map.put(rightChar, right);
            right++;
        }

        if (map.size() > max) {
            max = map.size();
        }

        return max;
    }
}
