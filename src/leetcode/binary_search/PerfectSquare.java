package leetcode.binary_search;

public class PerfectSquare {

    public static void main(String[] args) {
        new PerfectSquare().isPerfectSquare(1804289383);
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int x = sqrt(num);
        if (x == -1) return false;
        return true;
    }

    int sqrt(int num) {
        int left = 1;
        int right = num;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            long square = (long) middle * middle;
            if (square == num) return middle;

            if (square <=0 || square > num) right = middle - 1;
            else left = middle + 1;
        }

        return -1;
    }

}
