package leetcode;

class SortColors {

    static final int RED = 0;
    static final int WHITE = 1;
    static final int BLUE = 2;

    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for(int i=0; i<nums.length;i++) {
            if (nums[i] == RED) redCount++;
            else if (nums[i] == WHITE) whiteCount++;
            else if (nums[i] == BLUE) blueCount++;
        }

        int index = -1;
        while (redCount > 0 || whiteCount > 0 || blueCount > 0) {
            index++;

            if (redCount > 0) {
                nums[index] = RED;
                redCount--;
                continue;
            }

            if (whiteCount > 0) {
                nums[index] = WHITE;
                whiteCount--;
                continue;
            }

            if (blueCount > 0) {
                nums[index] = BLUE;
                blueCount--;
                continue;
            }
        }

    }

}
