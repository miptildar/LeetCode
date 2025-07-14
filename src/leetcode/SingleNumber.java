package leetcode;

class SingleNumber {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int val = 0;
        for (int i=0; i<length; i++) {
            val = val ^ nums[i];
        }

        return val;
    }
}
