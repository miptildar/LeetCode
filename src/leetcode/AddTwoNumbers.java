package leetcode;

class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultRoot = null;
        ListNode currentNode = null;

        int memory = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int sum = memory + l1Val + l2Val;
            if (sum > 9) {
                sum = sum - 10;
                memory = 1;
            } else {
                memory = 0;
            }

            if (resultRoot == null) {
                resultRoot = new ListNode(sum);
                currentNode = resultRoot;
            } else {
                currentNode.next = new ListNode(sum);
                currentNode = currentNode.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (memory == 1) {
            currentNode.next = new ListNode(1);
        }

        return resultRoot;
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

