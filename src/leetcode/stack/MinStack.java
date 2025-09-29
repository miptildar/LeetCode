package leetcode.stack;

public class MinStack {
    Node top;
    Node topMin;

    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val);
        if (top == null) {
            top = node;
            topMin = new Node(val);
        } else {
            node.bottom = top;
            top = node;

            Node nodeMin = new Node();
            if (topMin.val < val) {
                nodeMin.val = topMin.val;
            } else {
                nodeMin.val = val;
            }

            nodeMin.bottom = topMin;
            topMin = nodeMin;
        }
    }

    public void pop() {
        top = top.bottom;
        topMin = topMin.bottom;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return topMin.val;
    }

    private static class Node {
        int val;
        Node bottom;
        Node() {}
        Node(int val) {this.val = val;}
    }
}
