package leetcode.binary_search;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {

            if (right - left == 0) {
                if (isBadVersion(left))
                    return left;

                return left + 1;
            }

            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (isBadVersion(left)) return left;
        return right;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
