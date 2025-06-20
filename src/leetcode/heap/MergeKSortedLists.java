package leetcode.heap;

class MergeKSortedLists {

    ListNode[] heap;
    int size = 0;

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        heap = new ListNode[lists.length + 1];

        for (ListNode node : lists) {
            add(node);
        }

        if (size == 0) {
            return null;
        }

        ListNode root = null;
        ListNode current = null;

        root = getMin();
        current = root;

        if (root != null && root.next != null) {
            add(root.next);
        }

        while (true) {

            ListNode node = getMin();

            if (node == null) {
                break;
            }

            if (node.next != null) {
                add(node.next);
            }

            current.next = node;
            current = node;
        }

        return root;
    }

    void add(ListNode node) {
        if (node == null) {
            return;
        }

        size++;
        heap[size] = node;

        int index = size;
        while (index > 1) {
            int parent = index / 2;

            if (heap[parent].val > heap[index].val) {
                swapHeap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    ListNode getMin() {
        if (size < 1) {
            return null;
        }

        ListNode min = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while (index <= size / 2) {
            int left = 2 * index;
            int right = 2 * index + 1;

            if (heap[left].val < heap[index].val || heap[right].val < heap[index].val) {
                if (heap[left].val > heap[right].val) {
                    swapHeap(right, index);
                    index = right;
                } else {
                    swapHeap(left, index);
                    index = left;
                }
            } else {
                break;
            }
        }

        return min;
    }

    void swapHeap(int i1, int i2) {
        ListNode temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }

    private static class ListNode {
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
}
