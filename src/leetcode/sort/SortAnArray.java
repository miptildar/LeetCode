package leetcode.sort;

// heap sort
class SortAnArray {
    int[] heap;
    int size = 0;

    public int[] sortArray(int[] nums) {
        int arrLength = nums.length;

        heap = new int[arrLength + 1];

        for (int i=0; i < arrLength; i++) add(nums[i]);

        int[] sorted = new int[arrLength];
        for (int i=0; i < arrLength; i++) sorted[i] = getMin();
        return sorted;
    }

    void add(int val) {
        size++;
        heap[size] = val;

        int index = size;
        while (index > 1) {
            int parent = index / 2;
            if (heap[parent] > heap[index]) {
                int temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    int getMin() {
        int min = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while (index <= size / 2) {
            int left = index*2;
            int right = index*2+1;
            int smallest = index;

            if (left <= size && heap[smallest] > heap[left]) smallest = left;
            if (right <= size && heap[smallest] > heap[right]) smallest = right;

            if (smallest == index) break;

            int temp = heap[smallest];
            heap[smallest] = heap[index];
            heap[index] = temp;
            index = smallest;
        }

        return min;
    }

}
