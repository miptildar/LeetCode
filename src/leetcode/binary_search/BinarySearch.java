package leetcode.binary_search;

public class BinarySearch {
    public static int binarySearch (int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            int middleValue = nums[middle];
            if (middleValue == target) {
                return middle;
            }

            if (target > middleValue) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
