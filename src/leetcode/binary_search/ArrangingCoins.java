package leetcode.binary_search;

public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(1_804_289_383));
    }

    public int arrangeCoins(int n) {
        if (n == 1) return 1;

        int D = (int) sqrt(1 + 8L * n);
        return (int) ((D - 1) / 2);
    }

    private int atLeast(int rows) {
        return (1 + rows) * rows / 2;
    }

    long sqrt(long num) {
        long left = 1;
        long right = num;

        while (left <= right) {
            long middle = left + (right - left) / 2;
            long square = (long) middle * middle;
            if (square == num) return middle;

            if (square <= 0 || square > num) right = middle - 1;
            else left = middle + 1;
        }

        return Math.min(left, right);
    }

}
