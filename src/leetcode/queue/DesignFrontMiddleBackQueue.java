package leetcode.queue;

// not ready
public class DesignFrontMiddleBackQueue {

    public static void main(String[] args) {
        // pushMiddle","pushMiddle","pushMiddle","popMiddle","popMiddle","popMiddle
        DesignFrontMiddleBackQueue queue = new DesignFrontMiddleBackQueue();
        queue.pushMiddle(1);
        queue.print();
        queue.pushMiddle(2);
        queue.print();
        queue.pushMiddle(3);
        queue.print();
        queue.popMiddle();
        queue.print();
        queue.popMiddle();
        queue.print();
        queue.popMiddle();
        queue.print();
    }

    Node root = null;
    Node end = null;

    int size = 0;
    Node middle = null;

    void print() {
        Node node = root;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public DesignFrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        Node node = new Node(val);

        if (size == 0) {
            root = node;
            end = node;
            middle = node;
            size++;
            return;
        }

        root.prev = node;
        node.next = root;
        root = node;

        if (size % 2 == 0) {
            middle = middle.prev;
        }

        size++;
    }

    public void pushMiddle(int val) {
        Node node = new Node(val);

        if (size == 0) {
            root = node;
            end = node;
            middle = node;
            size++;
            return;
        }

        if (size % 2 == 0) {
            node.next = middle;
            node.prev = middle.prev;
            if (middle.prev != null) {
                middle.prev.next = node;
            } else {
                root = node;
            }
            middle.prev = node;
            middle = node;
        } else {
            node.next = middle;
            node.prev = middle.prev;
            if (middle.prev != null) {
                middle.prev.next = node;
            } else {
                root = node;
            }
            middle.prev = node;
            middle = node;
        }

        size++;
    }

    public void pushBack(int val) {
        Node node = new Node(val);

        if (size == 0) {
            root = node;
            end = node;
            middle = node;
            size++;
            return;
        }

        end.next = node;
        node.prev = end;
        end = node;

        if (size % 2 == 1) {
            middle = middle.next;
        }

        size++;
    }

    public int popFront() {
        if (size == 0) return -1;

        int val = root.val;

        if (size == 1) {
            root = null;
            end = null;
            middle = null;
        } else {
            root = root.next;
            root.prev = null;

            if (size % 2 == 1) {
                middle = middle.next;
            }
        }

        size--;
        return val;
    }

    public int popMiddle() {
        if (size == 0) return -1;

        int val = middle.val;
        if (size == 1) {
            root = null;
            end = null;
            middle = null;
        } else if (size % 2 == 1) {
            Node prev = middle.prev;
            Node next = middle.next;

            if (prev != null) prev.next = next;
            else root = next;

            if (next != null) next.prev = prev;
            else end = prev;

            middle = next;
        } else {
            Node prev = middle.prev;
            Node next = middle.next;
            if (prev != null) prev.next = next;
            else root = next;

            if (next != null) next.prev = prev;
            else end = prev;

            middle = prev;
        }

        size--;
        return val;
    }

    public int popBack() {
        if (size == 0) return -1;

        int val = end.val;
        if (size == 1) {
            root = null;
            end = null;
            middle = null;
        } else {
            end = end.prev;
            end.next = null;
            if (size % 2 == 0) {
                middle = middle.prev;
            }
        }
        size--;
        return val;
    }

    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int v) {
            val = v;
        }
    }
}
