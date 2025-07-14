package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        new MinimumAbsoluteDifference().minimumAbsDifference(new int[] {4,2,1,3});
    }

    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        int len = nums.length; // len >= 2

        quickSort(nums, 0, len - 1);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = nums[len - 1] - nums[0];

        int i = 0;
        while (i < len - 1) {
            int diff = nums[i + 1] - nums[i];
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(List.of(nums[i], nums[i+1]));
            } else if (diff == minDiff) {
                result.add(List.of(nums[i], nums[i+1]));
            }

            i++;
        }

        return result;
    }

    void quickSort(int[] mas, int low, int high) {
        if (low < high) {
            int partition = partition(mas, low, high);

            quickSort(mas, low, partition - 1);
            quickSort(mas, partition + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int lastKnown = low - 1;
        int index = low;
        while (index < high) {

            if (arr[index] <= pivot) {
                lastKnown++;
                swap(arr, index, lastKnown);
            }
            index++;
        }

        swap(arr, lastKnown + 1, high);
        return lastKnown + 1;
    }

    void swap(int[] mas, int i, int j) {
        int temp = mas[i];
        mas[i] = mas[j];
        mas[j] = temp;
    }

}
