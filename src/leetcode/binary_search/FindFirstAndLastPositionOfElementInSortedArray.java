package leetcode.binary_search;

class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1,3}, 1);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};

        int index = search(nums, target);
        if (index == -1) return new int[]{-1,-1};

        int left = index;
        int right = index;

        while (true) {
            if (left > 0 && nums[left - 1] == target) left--;
            else if (right < nums.length - 1 && nums[right + 1] == target) right++;
            else break;
        }

        return new int[] {left, right};

    }

    int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right && left < nums.length && right >= 0) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }

}
