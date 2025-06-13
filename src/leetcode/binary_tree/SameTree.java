package leetcode.binary_tree;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q, true);
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

        return dfs(a.left, b.left, theSame) && dfs(a.right, b.right, theSame);
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
