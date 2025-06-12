package leetcode;

public class ValidPalindrome {

    public static void main(String[] args) {
        boolean palindrome = new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
        System.out.printf("palindrome: %b", palindrome);
    }

    public boolean isPalindrome(String s) {
        int length = s.length();
        s = s.toLowerCase();
        for (int left = 0, right = length - 1; left < right;) {

            char leftChar = s.charAt(left);
            if (!isAlphanumeric(leftChar)) {
                left ++;
                continue;
            }

            char rightChar = s.charAt(right);
            if (!isAlphanumeric(rightChar)) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    boolean isAlphanumeric(char c) {
        return ((c - 'a' < 26) && (c - 'a' >= 0))
                || ( (c - '0' < 10) && (c - '0' >= 0));
    }
}
