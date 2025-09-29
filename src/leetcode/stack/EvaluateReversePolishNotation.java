package leetcode.stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack stack = new Stack();

        for (int i=0; i < tokens.length; i++) {
            String token = tokens[i];
            if ("+".equals(token)) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x + y);
            } else if ("-".equals(token)) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y - x);
            } else if ("*".equals(token)) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x * y);
            } else if ("/".equals(token)) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y / x);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
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
