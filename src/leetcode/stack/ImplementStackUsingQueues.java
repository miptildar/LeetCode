package leetcode.stack;

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        ImplementStackUsingQueues x = new ImplementStackUsingQueues();
        x.push(1);
        x.push(2);
        x.top();
        x.pop();
        x.empty();
    }

    Node last;
    Node front;
    int size = 0;

    public ImplementStackUsingQueues() {

    }

    public void push(int x) {
        pushQueue(x);
    }

    public int pop() {
        if (size == 0) return -1;

        if (size == 1) {
            int value = last.val;
            last = null;
            front = null;
            size = 0;
            return value;
        }

        int index = 0;
        while(index < size - 1) {
            int pop = popQueue();
            pushQueue(pop);
            index++;
        }

        int val = popQueue();
        return val;
    }

    private void pushQueue(int val) {
        Node node = new Node(val);
        if (size == 0) {
            last = node;
            front = node;
            size++;
            return;
        }

        last.prev = node;
        last = node;
        size++;
    }

    private int popQueue() {
        if (size == 0) return -1;

        int value = front.val;
        front = front.prev;
        size--;

        return value;
    }

    public int top() {
        if (size == 0) return -1;
        return last.val;
    }

    public boolean empty() {
        return size == 0;
    }

    static class Node {
        int val;
        Node prev;
        Node(int val) {this.val = val;}
    }
}
