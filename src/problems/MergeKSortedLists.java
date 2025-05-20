package problems;

import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode root = new ListNode();
        new MergeKSortedLists().mergeKLists(new ListNode[]{root});
    }

    private ListInHeap[] heap;

    public ListNode mergeKLists(ListNode[] lists) {

        for (int i = 0; i < lists.length; i++) {
            ListNode item = lists[i];
            while (item != null) {
                insertHeap(new ListInHeap(i, item.val));
                item = item.next;
            }
        }


        return null;
    }

    private void insertHeap(ListInHeap value) {

    }

    private ListInHeap extractHeap() {
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class ListInHeap {
        int index;
        int value;

        public ListInHeap(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }

}
