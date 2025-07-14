package leetcode.sort;

public class HeightChecker {

    public static void main(String[] args) {
        new HeightChecker().heightChecker(new int[]{1,1,4,2,1,3});
    }

    public int heightChecker(int[] heights) {
        int[] sorted = new int[heights.length];
        System.arraycopy(heights, 0, sorted, 0, heights.length);

        bubbleSort(sorted);
        int counter = 0;
        for (int i=0; i<heights.length; i++) {
            if (heights[i] != sorted[i]) counter++;
        }

        return counter;
    }

    void bubbleSort(int[] arr) {
        boolean hasSwapped = true;
        while(hasSwapped) {
            hasSwapped = false;
            for (int i=0; i<arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }

}
