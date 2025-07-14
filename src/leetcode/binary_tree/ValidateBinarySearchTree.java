package leetcode.binary_tree;

class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        TreeNode n2 = new TreeNode(2);
        n2.left = n1;
        n2.right = n3;


        System.out.println(new ValidateBinarySearchTree().isValidBST(n2));
    }

    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return valid;
    }

    void dfs(TreeNode parent, long min, long max) {
        if (!valid) {
            return;
        }

        int parentValue = parent.val;

        if (parent.left != null) {
            int leftValue = parent.left.val;

            if (parentValue <= leftValue || leftValue >= max || leftValue <= min) {
                valid = false;
                return;
            }

            dfs(parent.left, min, parentValue);
        }


        if (parent.right != null) {
            int rightValue = parent.right.val;

            if (parentValue >= rightValue || rightValue >= max || rightValue <= min) {
                valid = false;
                return;
            }

            dfs(parent.right, parentValue, max);
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
