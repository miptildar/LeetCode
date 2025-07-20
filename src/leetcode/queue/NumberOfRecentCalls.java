package leetcode.queue;

public class NumberOfRecentCalls {
    int size;
    Node root = null;
    Node end = null;

    public NumberOfRecentCalls() {
        size = 0;
    }

    public int ping(int t) {
        Node node = new Node(t);
        if (root == null) {
            root = node;
            end = node;
            size++;
            return 1;
        }

        end.next = node;
        end = node;
        size++;

        while (t - root.val > 3000) {
            root = root.next;
            size--;
        }

        return size;
    }

    static class Node {
        int val;
        Node next = null;
        Node(int val) {this.val = val;}
    }
}
