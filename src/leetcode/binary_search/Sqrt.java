package leetcode.binary_search;

class Sqrt {

    public int mySqrt(int x) {

        if (x == 0 || x == 1) return x;

        if (x == 2 || x == 3) return 1;

        int low = 0;
        int high = x;

        if (x > 46341) {
            high = 46341;
        }

        while (high - low != 1) {
            int mid = low + (high - low) / 2;

            long midSquare = mid * mid;
            if (midSquare == x) return mid;

            if (midSquare > x) {
                high = mid;
                continue;
            }

            if (high * high == x) {
                return high;
            }

            if (midSquare < x) {
                low = mid;
                continue;
            }
        }

        return low;
    }

}
