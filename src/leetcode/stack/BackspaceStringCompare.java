package leetcode.stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack a = new Stack();
        Stack b = new Stack();

        int i1 = 0;
        int i2 = 0;
        while (i1 < s.length() || i2 < t.length()) {

            if (i1 < s.length()) {
                char c = s.charAt(i1);
                if (c == '#') a.pop();
                else a.push(c);

                i1++;
            }

            if (i2 < t.length()) {
                char c = t.charAt(i2);
                if (c == '#') b.pop();
                else b.push(c);

                i2++;
            }
        }

        if (a.size != b.size) return false;

        Character x = a.pop();
        Character y = b.pop();
        while (x != null && y != null) {
            if (x != y) return false;
            x = a.pop();
            y = b.pop();
        }

        return a.size == b.size;
    }

    static class Stack {
        Node top;
        int size = 0;

        void push(char c) {
            Node node = new Node(c);
            size++;
            if (top == null) {
                top = node;
                return;
            }

            node.bottom = top;
            top = node;
        }

        Character pop() {
            if (size == 0) return null;

            Character c = top.val;
            top = top.bottom;
            size--;
            return c;
        }

    }

    static class Node {
        char val;
        Node bottom;
        Node(char val) {this.val = val;}
    }
}
