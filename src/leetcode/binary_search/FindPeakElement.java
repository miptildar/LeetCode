package leetcode.binary_search;

public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1,2,1,2,1}));
    }

    public int findPeakElement(int[] nums) {

        if (nums.length == 1) return 0;

        if (nums[0] > nums[1]) return 0;

        int length = nums.length;
        if (nums[length - 2] < nums[length - 1]) return length - 1;


        int left = 0;
        int right = length - 1;

        while (right - left > 1) {
            int middle = left + (right - left) / 2;

            if (nums[middle - 1] < nums[middle] && nums[middle] > nums[middle + 1]) {
                return middle;
            }

            if (nums[middle - 1] > nums[middle] && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            }

            // ascending
            if (nums[middle - 1] < nums[middle] && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            }

            // descending
            if (nums[middle - 1] > nums[middle] && nums[middle] > nums[middle + 1]) {
                right = middle - 1;
            }
        }

        if (nums[left] >  nums[right]) return left;
        return right;

    }

}
