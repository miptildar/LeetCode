package leetcode.sort;

class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        new SortList().sortList(head);
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        return mergeSort(head, last);
    }

    ListNode mergeSort(ListNode left, ListNode right) {
        right.next = null;

        ListNode mid = findMid(left, right);

        // 2 elements
        if (mid.next == right) {
            mid.next = null;
            return merge(mid, right);
        }

        ListNode a = mergeSort(left, mid);
        ListNode b = mergeSort(mid.next, right);

        return merge(a, b);
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode head = null;
        ListNode current = null;
        while (a != null || b != null) {

            if (a != null && b != null) {
                ListNode max = a.val > b.val ? a : b;
                ListNode min = a.val > b.val ? b : a;

                if (head == null) {
                    head = new ListNode(min.val);
                    head.next = new ListNode(max.val);
                    current = head.next;
                } else {
                    current.next = new ListNode(min.val);
                    current.next.next = new ListNode(max.val);
                    current = current.next.next;
                }

                a = a.next;
                b = b.next;

            } else if (a != null) {
                if (head == null) {
                    head = new ListNode(a.val);
                    current = head;
                } else {
                    current.next = new ListNode(a.val);
                    current = current.next;
                }

                a = a.next;
            } else {
                if (head == null) {
                    head = new ListNode(b.val);;
                    current = head;
                } else {
                    current.next = new ListNode(b.val);
                    current = current.next;
                }

                b = b.next;
            }
        }

        return head;
    }

    ListNode findMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != null && fast.next != null) {

            if (fast.next.next == null || fast.next.next == right) {
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
