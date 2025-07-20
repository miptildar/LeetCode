package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

// intentionally using sorting
public class MajorityElement2 {

    public static void main(String[] args) {
        new MajorityElement2().majorityElement(new int[]{-1,-1,-2,-2});
    }

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;

        if (len == 1) return List.of(nums[0]);
        if (len == 2) {
            if (nums[0] != nums[1]) return List.of(nums[0], nums[1]);
            return List.of(nums[0]);
        }

        int threshold = len / 3;
        quickSort(nums, 0, len - 1);

        List<Integer> result = new ArrayList<>();
        int index = 0;
        int current = nums[0];
        while (index < len) {
            int jumpIndex = index + threshold;
            if (jumpIndex < len && nums[jumpIndex] == current) {
                result.add(current);
                index = jumpIndex;
                while (index + 1 < len && nums[index + 1] == current) index++;
            } else {
                while (index + 1 < len && nums[index + 1] == current) index++;
            }

            index++;
            if (index < len) {
                current = nums[index];
            }
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

    int partition(int[] mas, int low, int high) {
        int pivot = mas[high];

        int last = low - 1;
        int index = low;
        while (index < high) {

            if (mas[index] <= pivot) {
                last++;
                swap(mas, last, index);
            }

            index++;
        }

        swap(mas, last+1, index);
        return last + 1;
    }

    void swap(int[] mas, int x, int y) {
        int temp = mas[x];
        mas[x] = mas[y];
        mas[y] = temp;
    }
}
