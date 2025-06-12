package leetcode;

import java.util.HashSet;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashSet<Integer> pairs = new HashSet<Integer>();
        for (int i=0; i<A.length; i++) {
            int value = A[i];
            if (pairs.contains(value)) {
                pairs.remove(value);
            } else {
                pairs.add(value);
            }
        }

        return pairs.iterator().next();
    }
}
