package leetcode;

// similar to SameTree problem, but with small modifications
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right, true);
    }

    boolean dfs(TreeNode a, TreeNode b, boolean theSame) {
        if (!theSame) {
            return false;
        }

        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        if (a == null && b == null) {
            return theSame;
        }

        if (a.val != b.val) {
            return false;
        }

        return dfs(a.left, b.right, theSame) && dfs(a.right, b.left, theSame);
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
