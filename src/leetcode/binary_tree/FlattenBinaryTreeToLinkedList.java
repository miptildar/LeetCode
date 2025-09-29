package leetcode.binary_tree;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        TreeNode flatRoot = new TreeNode();
        dfs(root, flatRoot);

        root.left = null;
        root.right = flatRoot.right;
    }

    TreeNode dfs(TreeNode parent, TreeNode flatParent) {

        flatParent.val = parent.val;

        if (parent.left != null) {
            flatParent.right = new TreeNode();
            flatParent = dfs(parent.left, flatParent.right);
        }

        if (parent.right != null) {
            flatParent.right = new TreeNode();
            flatParent = dfs(parent.right, flatParent.right);
        }

        return flatParent;
    }

    static class TreeNode {
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
