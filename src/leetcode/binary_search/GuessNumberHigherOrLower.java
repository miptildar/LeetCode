package leetcode.binary_search;

public class GuessNumberHigherOrLower {

    int pick = 1702766719;

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int guess = guess(middle);
            if (guess == 0)
                return middle;

            if (guess == 1) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return 0;
    }

    int guess(int num) {
        if (num > pick) return -1;
        if (num < pick) return 1;
        return 0;
    }
}
