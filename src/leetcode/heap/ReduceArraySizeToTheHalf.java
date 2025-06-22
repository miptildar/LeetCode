package leetcode.heap;

import java.util.HashMap;
import java.util.Map;

class ReduceArraySizeToTheHalf {

    Pair[] heap;
    int size;

    public int minSetSize(int[] arr) {

        Map<Integer, Pair> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            Pair pair = map.getOrDefault(arr[i], new Pair(arr[i]));
            pair.count++;
            map.put(arr[i], pair);
        }

        heap = new Pair[map.values().size() + 1];

        for (Pair pair : map.values()) {
            add(pair);
        }

        int remaining = arr.length;
        int atLeastHalf = arr.length / 2;
        int counter = 0;
        while (remaining > atLeastHalf) {
            Pair pair = getMax();
            remaining -= pair.count;
            counter++;
        }

        return counter;
    }

    void add(Pair pair) {
        size++;
        heap[size] = pair;

        int index = size;
        while (index > 1) {
            int parent = index / 2;
            if (heap[index].count > heap[parent].count) {
                Pair temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    Pair getMax() {
        Pair max = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while(index <= size / 2) {
            int left = index*2;
            int right = index*2 + 1;

            int largest = index;

            if (left <= size && heap[left].count > heap[largest].count) {
                largest = left;
            }

            if (right <= size && heap[right].count > heap[largest].count) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            Pair temp = heap[largest];
            heap[largest] = heap[index];
            heap[index] = temp;
            index = largest;
        }

        return max;
    }

    static class Pair {
        int val;
        int count=0;
        Pair(int val) {
            this.val = val;
        }
    }
}
