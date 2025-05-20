package problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode a = new ListNode(3);

        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);



        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        new LinkedListCycle().hasCycle(a);
    }

    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();

        int index = 0;
        while (node != null) {
            if (set.contains(node)) {
                return true;
            }

            set.add(node);

            index++;
            node = node.next;
        }

        return false;
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
