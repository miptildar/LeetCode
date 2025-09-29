package leetcode.stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        ImplementQueueUsingStacks op = new ImplementQueueUsingStacks();
        op.push(1);
        op.push(2);
        op.push(3);
        op.push(4);
        op.pop();
        op.push(5);
        op.pop();
        op.pop();
        op.pop();
    }

    static final int UNKNOWN = -1;
    static final int PUSH = 1;
    static final int POP_PEEK = 2;

    Stack active;
    Stack passive;

    int lastOperation = UNKNOWN;

    public ImplementQueueUsingStacks() {
        active = new Stack();
        passive = new Stack();
    }

    public void push(int x) {
        if (lastOperation == PUSH || lastOperation == UNKNOWN) {
            active.push(x);
            lastOperation = PUSH;
            return;
        }

        swap();
        active.push(x);
        lastOperation = PUSH;
    }

    public int pop() {
        if (lastOperation == POP_PEEK) {
            int val = active.pop();
            return val;
        }

        swap();
        int val = active.pop();
        lastOperation = POP_PEEK;

        return val;
    }

    public int peek() {
        if (lastOperation == POP_PEEK) {
            return active.peek();
        }

        swap();
        int val = active.peek();
        lastOperation = POP_PEEK;

        return val;
    }

    public boolean empty() {
        return active.size == 0;
    }

    void swap() {
        if (empty()) return;

        int val = active.pop();
        while (val != -1) {
            passive.push(val);
            val = active.pop();
        }

        Stack temp = active;
        active = passive;
        passive = temp;

    }

    static class Stack {
        Node top;
        int size = 0;

        void push(int val) {
            Node node = new Node(val);
            if (top == null) {
                top = node;
                size++;
                return;
            }

            node.bottom = top;
            top = node;
            size++;
        }

        int pop() {
            if (size == 0) return -1;

            int val = top.val;
            top = top.bottom;
            size--;
            return val;
        }

        int peek() {
            if (size == 0) return -1;
            return top.val;
        }
    }

    static class Node {
        int val;
        Node bottom;
        Node(int val) {this.val = val;}
    }
}
