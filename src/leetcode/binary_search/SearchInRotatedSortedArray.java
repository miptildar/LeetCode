package leetcode.binary_search;

// beat 100% Runtime, 97% Memory
class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int length = nums.length;
        if (length == 1) {
            if (nums[0] == target) return 0;
            return -1;
        }

        int minPivot = findMinPivot(nums);
        if (minPivot == -1) {
            return binarySearch(nums, 0, length - 1, target);
        }

        if (target <= nums[minPivot - 1] && target >= nums[0]) { // left range
            return binarySearch(nums, 0, minPivot - 1, target);
        }

        return binarySearch(nums, minPivot, length - 1, target); // right range
    }

    // finding first index i that nums[i] < y
    private int findMinPivot(int[] nums) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;
        int y = nums[0];


        while (right - left >= 0) {
            int middle = left + (right - left) / 2;

            if (nums[middle] >= y) {
                left = middle + 1;
                continue;
            }

            if (nums[middle] < y) {
                right = middle - 1;
            }
        }

        if (left >= length) return -1;
        return left;
    }

    int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;

        while (right - left >= 0) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) return middle;

            if (target > nums[middle]) {
                left = middle + 1;
                continue;
            }

            right = middle - 1;
        }

        return -1;
    }

}
