package leetcode.bits;

public class SetMismatch {

    public static void main(String[] args) {
        new SetMismatch().findErrorNums(new int[]{2,2});
    }

    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int x = 0;
        for (int i =0; i<len; i++) x = x ^ nums[i];
        for (int i=1; i<=len; i++) x = x ^ i;

        for (int i=1; i<=len; i++) {
            if ((i ^ (i+1)) == x) return new int[] {i, i + 1};
        }

        return new int[] {0,0};
    }
}
