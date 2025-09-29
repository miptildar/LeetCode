package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

class SimplifyPath {

    public static void main(String[] args) {
        new SimplifyPath().simplifyPath("/.../a/../b/c/../d/./");
    }

    static final String SLASH = "/";
    Node top;

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();

        String[] parts = path.split("/");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) continue;

            if (part.equals("..")) {
                pop();
                continue;
            }

            if (part.equals(".")) {
                continue;
            }

            push(part);
        }

        List<String> list = new ArrayList<>();
        while (true) {
            String part = pop();
            if (part == null) break;
            list.add(part);
        }

        sb.append(SLASH);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i > 0) sb.append(SLASH);
        }

        return sb.toString();
    }

    void push(String part) {
        Node node = new Node(part);
        if (top == null) {
            top = node;
            return;
        }

        node.bottom = top;
        top = node;
    }

    String pop() {
        if (top == null) return null;

        Node node = top;
        top = top.bottom;
        return node.part;
    }

    static class Node {
        String part;
        Node bottom;

        Node(String part) {
            this.part = part;
        }
    }
}
