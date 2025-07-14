package leetcode.binary_tree;

class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return 0;
        }

        dfs(root, new Result(0, 0));

        return maxSubtreeNodesInRow - 1;
    }

    int maxSubtreeNodesInRow = 0;

    // postOrder
    Result dfs(TreeNode parent, Result result) {

        if (parent == null) {
            return result;
        }

        Result leftLevel = dfs(parent.left, result);

        Result rightLevel = dfs(parent.right, result);

        int subtreeNodesInRow = leftLevel.depth + rightLevel.depth + 1;
        int subtreeDepth = Math.max(leftLevel.depth, rightLevel.depth) + 1;

        if (subtreeNodesInRow > maxSubtreeNodesInRow) {
            maxSubtreeNodesInRow = subtreeNodesInRow;
        }

        return new Result(subtreeNodesInRow, subtreeDepth);
    }

    static class Result {
        int nodesInRow;
        int depth;

        Result(int nodesInRow, int depth) {
            this.nodesInRow = nodesInRow;
            this.depth = depth;
        }
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
