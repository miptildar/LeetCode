package leetcode.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {

    Pair[] heap;
    int size = 0;

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Pair> countMap = new HashMap<>();

        for (int i=0; i<words.length; i++) {
            String word = words[i];
            Pair pair = countMap.getOrDefault(word, new Pair(words[i]));
            pair.count++;
            countMap.put(word, pair);
        }

        heap = new Pair[countMap.values().size() + 1];

        for (Pair pair : countMap.values()) {
            add(pair);
        }

        List<String> result = new ArrayList<>();
        int counter = 0;
        while (counter < k) {
            result.add(getMax().word);
            counter++;
        }



        return result;
    }

    void add(Pair pair) {
        size++;
        heap[size] = pair;

        int index = size;
        while (index > 1) {
            int parent = index / 2;

            if (heap[index].compareTo(heap[parent]) > 0) {
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
        while (index <= size / 2) {
            int left = index*2;
            int right = index*2 + 1;

            int largest = index;
            if (left <= size && heap[left].compareTo(heap[largest]) > 0) {
                largest = left;
            }

            if (right <= size && heap[right].compareTo(heap[largest]) > 0) {
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

    static class Pair implements Comparable<Pair> {
        String word;
        int count = 0;
        Pair(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Pair other) {
            if (count > other.count)
                return 1;

            if (count < other.count)
                return -1;

            return other.word.compareTo(word);
        }
    }

}
