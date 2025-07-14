package leetcode.binary_tree;

// inorder, but right node first
class ConvertBstToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        inOrderDfs(root, 0);
        return root;
    }

    int inOrderDfs(TreeNode parent, int counter) {
        if (parent == null) {
            return counter;
        }

        counter = inOrderDfs(parent.right, counter);

        counter += parent.val;
        parent.val = counter;


        return inOrderDfs(parent.left, counter);
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
