package leetcode.sort;

public class MissingNumber {

    public static void main(String[] args) {
        new MissingNumber().missingNumber(new int[]{3,0,1});
    }

    public int missingNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return binarySearch(nums);
    }

    int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == middle) {
                if (nums[middle + 1] != middle + 1) return middle + 1;

                left = middle + 1;
            } else {
                if (nums[middle - 1] == middle - 1) return middle;
                right = middle - 1;
            }
        }

        return -1;
    }

    void quickSort(int[] mas, int low, int high) {
        if (low < high) {
            int partition = partition(mas, low, high);

            quickSort(mas, low, partition - 1);
            quickSort(mas, partition + 1, high);
        }
    }

    int partition(int[] mas, int low, int high) {
        int pivot = mas[high];

        int last = low - 1;
        int index = low;
        while (index < high) {

            if (mas[index] <= pivot) {
                last++;
                swap(mas, index, last);
            }
            index++;
        }

        swap(mas, last+1, index);
        return last+1;
    }

    void swap(int[] mas, int x, int y) {
        int temp = mas[x];
        mas[x] = mas[y];
        mas[y] = temp;
    }

}
