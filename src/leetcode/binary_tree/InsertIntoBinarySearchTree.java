package leetcode.binary_tree;

public class InsertIntoBinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        dfs(root, val);
        return root;
    }

    void dfs(TreeNode parent, int val) {
        int parentValue = parent.val;
        if (val < parentValue) {
            if (parent.left != null) {
                dfs(parent.left, val);
            } else {
                parent.left = new TreeNode(val);
                return;
            }
        } else {
            if (parent.right != null) {
                dfs(parent.right, val);
            } else {
                parent.right = new TreeNode(val);
                return;
            }
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
