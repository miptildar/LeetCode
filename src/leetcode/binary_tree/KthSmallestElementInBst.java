package leetcode.binary_tree;

public class KthSmallestElementInBst {

    public int kthSmallest(TreeNode root, int k) {
        inOrderDfs(root, k, 0);
        return smallestValue;
    }

    Integer smallestValue;

    int inOrderDfs(TreeNode parent, int k, int counter) {
        if (parent == null) {
            return counter;
        }

        if (smallestValue != null)
            return counter;

        counter = inOrderDfs(parent.left, k, counter);
        counter++;

        if (counter == k && smallestValue == null) {
            smallestValue = parent.val;
            return counter;
        }
        return inOrderDfs(parent.right, k, counter);
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
