package leetcode;

public class ValidAnagram {

    public static void main(String[] args) {
        new ValidAnagram().isAnagram("rat", "car");
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char z = 'z';
        char a = 'a';
        int alphabetLen = z - a + 1;
        int[] mas1 = new int[alphabetLen];
        int[] mas2 = new int[alphabetLen];

        int len = s.length();
        for (int i = 0; i < len; i++) {
            mas1[z - s.charAt(i)]++;
            mas2[z - t.charAt(i)]++;
        }

        for (int i = 0; i < alphabetLen; i++) {
            if (mas1[i] != mas2[i]) return false;
        }

        return true;
    }
}
