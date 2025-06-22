package leetcode.heap;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementInStream {

    List<Integer> heap;
    int size = 0;
    int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;

        heap = new ArrayList<>(2);

        for (int i=0; i<nums.length; i++) {
            addMin(nums[i]);
        }

        while (size > k) {
            removeMin();
        }
    }

    public int add(int val) {
        addMin(val);

        if (size > k) {
            removeMin();
        }

        return heap.get(1);
    }

    void addMin(int val) {
        size++;

        while (heap.size() <= size + 1) {
            heap.add(null);
        }
        heap.set(size, val);

        int index = size;
        while (index > 1) {
            int parent = index / 2;

            if (heap.get(index) < heap.get(parent)) {
                int temp = heap.get(parent);
                heap.set(parent, heap.get(index));
                heap.set(index, temp);
                index = parent;
            } else {
                break;
            }
        }
    }

    void removeMin() {
        heap.set(1, heap.get(size));
        size--;

        int index = 1;
        while (index <= size / 2) {
            int left = index*2;
            int right = index*2 + 1;

            int smallest = index;

            if (left <= size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right <= size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            int temp = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temp);

            index = smallest;
        }
    }

}
