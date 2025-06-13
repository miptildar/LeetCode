package leetcode.binary_tree;

// postorder is necessary
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);

        TreeNode n9 = new TreeNode(9, null, null);

        TreeNode n3 = new TreeNode(3, n9, n20);
        new BalancedBinaryTree().isBalanced(n3);
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    // -1 means not balanced
    int dfs(TreeNode parent) {
        if (parent == null) {
            return 0;
        }

        int leftSubtree = dfs(parent.left);
        int rightSubtree = dfs(parent.right);

        if (leftSubtree == -1 || rightSubtree == -1) {
            return -1;
        }

        if (Math.abs(leftSubtree - rightSubtree) > 1) {
            return -1;
        }

        return Math.max(leftSubtree, rightSubtree) + 1;
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
