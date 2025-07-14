package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    void dfs(TreeNode parent, List<Integer> list) {
        if (parent == null) {
            return;
        }

        list.add(parent.val);
        dfs(parent.left, list);
        dfs(parent.right, list);
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
