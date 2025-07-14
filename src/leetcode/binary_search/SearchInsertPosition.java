package leetcode.binary_search;

class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;

        while (right - left >= 0) {
            int middle = (left + right) / 2;

            if (nums[middle] == target)
                return middle;

            if (target > nums[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }

        if (left == size) {
            return left;
        }

        if (right == -1) {
            return 0;
        }

        return right + 1;

    }

}
