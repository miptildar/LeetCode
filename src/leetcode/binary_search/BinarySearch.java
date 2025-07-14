package leetcode.binary_search;

class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (right - left >= 0) {
            int middle = (left + right) / 2;

            if (nums[middle] == target)
                return middle;

            if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
