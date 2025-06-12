package leetcode;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] charTimes = new int[26];
        for (int i=0; i<s.length(); i++) {
            charTimes[s.charAt(i) - 'a']++;
        }

        for (int i=0; i<s.length(); i++) {
            if (charTimes[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
