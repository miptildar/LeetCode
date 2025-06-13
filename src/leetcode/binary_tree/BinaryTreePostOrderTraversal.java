package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    void dfs(TreeNode parent, List<Integer> list) {
        if (parent == null) {
            return;
        }

        dfs(parent.left, list);
        dfs(parent.right, list);
        list.add(parent.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
