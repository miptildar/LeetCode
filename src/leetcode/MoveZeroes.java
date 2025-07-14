package leetcode;

class MoveZeroes {

    // 0 1 3 5
    // 0 2 0 3 8
    // 1 2 0 3
    // 1 0 3 9

    // 1. move left pointer while nums[left] != 0
    // 2. if nums[left] == 0, find the next array value which is not 0
    // 3. replace

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        for (int left=0, right = 1; right<nums.length;) {
            int leftValue = nums[left];


            if (leftValue != 0) {
                left++;
                right++;
                continue;
            }

            int rightValue = nums[right];
            if (rightValue == 0) {
                right++;
                continue;
            }

            nums[left] = rightValue;
            nums[right] = 0;
            left++;
            right++;
        }
    }
}
