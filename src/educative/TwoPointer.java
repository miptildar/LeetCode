package educative;

class TwoPointer {

    public static void main(String[] args) {
        ListNode l1 = create(23);
        ListNode l2 = create(28);
        ListNode l3 = create(10);
        ListNode l4 = create(5);
        ListNode l5 = create(67);
        ListNode l6 = create(39);
        ListNode l7 = create(70);
        ListNode l8 = create(28);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        
    }

    public static ListNode create(int value) {
        return new ListNode(value);
    }

    public static ListNode removeNthLastNode(ListNode head, int n) {

        ListNode current = head;
        ListNode backward = null;
        while (current != null) {
            ListNode next = current.next;

            if (backward == null) {
                backward = current;
                current = next;
                continue;
            }

            current.next = backward;
            backward = current;
            current = next;
        }

        ListNode backwardCurrent = backward;
        int counter = 1;
        while (counter != n) {
            backwardCurrent = backwardCurrent.next;
            counter++;
        }

        return backwardCurrent;
    }

    static class ListNode {
        int val;
        ListNode next;

        // Constructor
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
