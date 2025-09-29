package leetcode.stack;

public class LongestAbsoluteFilePath {

    public static void main(String[] args) {
        System.out.println(
                new LongestAbsoluteFilePath().lengthLongestPath("a")
        );
    }

    Node top;

    public int lengthLongestPath(String input) {
        if (!input.contains("\n") && !isFile(input)) return 0;

        String[] parts = input.split("\n");

        int max = 0;

        for (int i=0; i<parts.length; i++) {
            String part = parts[i];
            int tabsCount = tabsCount(part);
            int textSize = parts[i].substring(tabsCount).length();

            int lastSize = top != null ? top.val : 0;
            int lastDepth = top != null ? top.depth : 0;

            if (tabsCount > lastDepth) {
                // going deeper

                int currentSize = lastSize + textSize + 1;
                push(currentSize, tabsCount);

                if (currentSize > max && isFile(part)) max = currentSize;

            } else if (tabsCount == lastDepth) {
                pop();
                lastSize = top != null ? top.val : 0;
                int currentSize = lastSize + textSize + 1;
                push(currentSize, tabsCount);
                if (currentSize > max && isFile(part)) max = currentSize;
            } else {

                // tabsCount < lastDepth
                int index = lastDepth;
                pop();
                while (index != tabsCount) {
                    pop();
                    index--;
                }

                lastSize = top != null ? top.val : 0;
                int currentSize = lastSize + textSize + 1;
                push(currentSize, tabsCount);
                if (currentSize > max && isFile(part)) max = currentSize;
            }

        }

        if (max == 0) return 0; // was never set
        return max - 1;
    }

    int tabsCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\t') {
                count++;
            }
        }
        return count;
    }

    boolean isFile(String str) {
        return str.contains(".");
    }

    void push(int val, int depth) {
        Node node = new Node(val, depth);
        if (top == null) {
            top = node;
        } else {
            node.bottom = top;
            top = node;
        }
    }

    void pop() {
        if (top == null) return;
        top = top.bottom;
    }

    static class Node {
        int val;
        int depth;
        Node bottom;
        Node() {}
        Node(int val, int depth) {this.val = val; this.depth = depth;}
    }
}
