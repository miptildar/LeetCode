package leetcode.binary_tree;

class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        n2.left = n7;
        n2.right = n4;

        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        n5.left = n6;
        n5.right = n2;

        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n1 = new TreeNode(1);
        n1.left = n0;
        n1.right = n8;


        TreeNode n3 = new TreeNode(3);
        n3.left = n5;
        n3.right = n1;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        lowestCommonAncestor.lowestCommonAncestor(n3, n5, n4);
        System.out.println(lowestCommonAncestor.lca.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        dfs(root, p.val, q.val);

        return lca;
    }

    TreeNode lca;

    // postorder
    int dfs(TreeNode parent, int p, int q) {
        if (parent == null) {
            return 0;
        }

        int leftResult = dfs(parent.left, p, q);
        int rightResult = dfs(parent.right, p, q);

        // parent can be leaf
        // parent can contain children

        // if parent leaf => compare value only
        // otherwise consider children too


        int counter = 0;
        counter += leftResult + rightResult;

        if (parent.val == q || parent.val == p) {
            counter++;
        }

        if (counter == 2 && lca == null) {
            lca = parent;
        }



        return counter;
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
