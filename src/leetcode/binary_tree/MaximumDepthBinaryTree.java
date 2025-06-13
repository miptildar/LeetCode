package leetcode.binary_tree;

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);

        TreeNode n9 = new TreeNode(9, null, null);

        TreeNode n3 = new TreeNode(3, n9, n20);
        System.out.println(new MaximumDepthBinaryTree().maxDepth(n3));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, 1, -1);

    }

    int dfs(TreeNode node, int currentDepth, int currentMax) {

        if (currentDepth > currentMax) {
            currentMax = currentDepth;
        }

        if (node.left != null) {
            currentMax = dfs(node.left, currentDepth + 1, currentMax);
        }

        if (node.right != null) {
            currentMax = dfs(node.right, currentDepth + 1, currentMax);
        }


        return currentMax;
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
