package educative;

import java.util.HashMap;
import java.util.Map;

class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        longestRepeatingCharacterReplacement(
                "ngmhdxlpjvgglacjbadbjysvwgditonibbwrhalzhnvbkuqdwwvmmilglrkjfwrftfazsmokqbhzcelylgovnmrbouqakmgfthhdiunoqxcbigtonbyhckqsnuxacflnmlxzlloceaicluuiddis",
                136);
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int max = 0;

        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> cache = new HashMap<>();
        int windowSize = k;
        int windowPosition = 0;

        // init cache
        for (int i = 0; i < windowSize && i < s.length(); i++) {
            cache.compute(s.charAt(i), (key, val) -> val == null ? 1 : val + 1);
        }

        do {
            int left = windowPosition;
            int right = windowPosition + windowSize;



        } while (windowSize + windowPosition < s.length());


        for (int left = 0; left < s.length() - 1; left++) {
            char leftChar = s.charAt(left);
            int remaining = k;
            int right = left + 1;
            while (right < s.length()) {
                char rightChar = s.charAt(right);
                if (leftChar == rightChar) {
                    right++;
                    continue;
                }

                if (remaining == 0) {
                    break;
                }

                remaining--;
                right++;
            }

            if (right - left > max) {
                max = right - left;
            }
        }

        return max;
    }
}
