package leetcode.hash_table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        for (int i=0; i<nums1.length; i++) first.add(nums1[i]);

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums2.length; i++) {
            if (first.contains(nums2[i])) list.add(nums2[i]);
        }

        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) result[i] = list.get(i);
        return result;
    }

}
