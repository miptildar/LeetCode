package leetcode.stack;

public class BaseballGame {

    public int calPoints(String[] operations) {
        Stack stack = new Stack();
        for (int i=0; i < operations.length; i++) {
            String op = operations[i];
            if ("+".equals(op)) {
                int x = stack.top.val;
                int y = stack.top.bottom.val;
                stack.push(x + y);
            } else if ("D".equals(op)) {
                stack.push(2*stack.top.val);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                // number
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        Integer x = stack.pop();
        while (x != null) {
            sum += x;
            x = stack.pop();
        }

        return sum;
    }

    static class Stack {
        Node top;
        int size=0;

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

        Integer pop() {
            if (size == 0) return null;

            int val = top.val;
            top = top.bottom;
            size--;

            if (size == 0) {
                top = null;
            }
            return val;
        }
    }

    static class Node {
        int val;
        Node bottom;
        Node(int val) {this.val = val;}
    }
}
