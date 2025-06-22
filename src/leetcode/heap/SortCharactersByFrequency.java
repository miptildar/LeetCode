package leetcode.heap;

import java.util.HashMap;
import java.util.Map;

// Runtime Beats 85.66%
// Memory Beats 75.23%
class SortCharactersByFrequency {

    CharCount[] heap;
    int size = 0;

    Map<Character, CharCount> countMap = new HashMap<>();

    public String frequencySort(String s) {
        if (s.length() == 1) {
            return s;
        }

        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            CharCount charCount = countMap.getOrDefault(c, new CharCount(c));
            charCount.count++;

            countMap.put(c, charCount);
        }

        heap = new CharCount[countMap.values().size() + 1];

        for (CharCount charCount : countMap.values()) {
            add(charCount);
        }

        StringBuilder sb = new StringBuilder();

        CharCount current = getMax();
        while (current != null) {

            for (int i=0;i<current.count; i++)
                sb.append(current.c);

            current = getMax();
        }

        return sb.toString();

    }

    void add(CharCount charCount) {
        size++;
        heap[size] = charCount;

        int index = size;
        while (index > 1) {
            int parent = index / 2;
            if (heap[parent].count < heap[index].count) {
                CharCount temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    CharCount getMax() {
        if (size == 0) {
            return null;
        }

        CharCount max = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while (index <= size / 2) {
            int left = index * 2;
            int right = index * 2 + 1;
            if (heap[left].count > heap[index].count || heap[right].count > heap[index].count) {

                if (heap[left].count > heap[right].count) {
                    CharCount temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    CharCount temp = heap[right];
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

    static class CharCount {
        char c;
        int count = 0;
        CharCount(char c) {
            this.c = c;
        }
    }
}
