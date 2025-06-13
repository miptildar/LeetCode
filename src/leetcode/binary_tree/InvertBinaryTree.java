package leetcode.binary_tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode reversed = new TreeNode();
        dfs(root, reversed);
        return reversed;
    }

    void dfs(TreeNode original, TreeNode reversed) {

        reversed.val = original.val;

        if (original.left != null) {
            TreeNode revRight = new TreeNode();
            reversed.right = revRight;

            dfs(original.left, reversed.right);
        }

        if (original.right != null) {
            TreeNode revLeft = new TreeNode();
            reversed.left = revLeft;

            dfs(original.right, reversed.left);
        }
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
