package leetcode.binary_tree;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        dfs(root, 0, targetSum);
        return found;
    }

    boolean found = false;

    void dfs(TreeNode parent, int currentSum, int targetSum) {
        if (found) {
            return;
        }

        if (parent == null) {
            return;
        }

        currentSum += parent.val;

        if (parent.left == null && parent.right == null && currentSum == targetSum) {
            found = true;
        }

        dfs(parent.left, currentSum, targetSum);
        dfs(parent.right, currentSum, targetSum);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
