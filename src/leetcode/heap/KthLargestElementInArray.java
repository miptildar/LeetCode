package leetcode.heap;

class KthLargestElementInArray {

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    int[] maxHeap;
    int heapSize = 0;

    public int findKthLargest(int[] nums, int k) {
        maxHeap = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

        int max = getMax();
        for (int i = 2; i <= k; i++) {
            max = getMax();
        }

        return max;
    }

    void add(int value) {
        heapSize++;
        maxHeap[heapSize] = value;

        int index = heapSize;

        while (index > 1) {
            int parent = index / 2;
            if (maxHeap[index] > maxHeap[parent]) {
                int temp = maxHeap[parent];
                maxHeap[parent] = maxHeap[index];
                maxHeap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    int getMax() {
        int max = maxHeap[1];
        maxHeap[1] = maxHeap[heapSize];
        heapSize--;

        int index = 1;
        while (index <= heapSize / 2) {
            int left = index * 2;
            int right = index * 2 + 1;

            if (maxHeap[left] > maxHeap[index] || maxHeap[right] > maxHeap[index]) {

                if (maxHeap[left] > maxHeap[right]) {
                    int temp = maxHeap[left];
                    maxHeap[left] = maxHeap[index];
                    maxHeap[index] = temp;
                    index = left;
                } else {
                    int temp = maxHeap[right];
                    maxHeap[right] = maxHeap[index];
                    maxHeap[index] = temp;
                    index = right;
                }

            } else {
                break;
            }
        }

        return max;
    }

}
