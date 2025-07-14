package leetcode.heap;

class LastStoneWeight {

    int heap[];
    int size = 0;

    public int lastStoneWeight(int[] stones) {
        heap = new int[stones.length + 1];

        for (int i=0; i<stones.length; i++) {
            add(stones[i]);
        }

        while (size > 1) {
            int max1 = getMax();
            int max2 = getMax();

            if (max1 != max2) {
                add(Math.abs(max1 - max2));
            }
        }

        if (size == 0) {
            return 0;
        } else {
            return getMax();
        }
    }

    void add(int value) {
        size++;
        heap[size] = value;

        int index = size;
        while (index > 1) {
            int parent = index / 2;
            if (heap[index] > heap[parent]) {
                int temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    int getMax() {
        int max = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while (index <= size / 2) {
            int left = 2*index;
            int right = 2*index + 1;

            if (heap[left] > heap[index] || heap[right] > heap[index]) {
                if (heap[left] > heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }


        return max;
    }
}
