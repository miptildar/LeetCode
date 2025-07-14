package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);

        TreeNode n9 = new TreeNode(9, null, null);

        TreeNode n3 = new TreeNode(3, n9, n20);

        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal().levelOrder(n3);
        System.out.println();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        LinkedList<List<TreeNode>> queue = new LinkedList<>();

        queue.addLast(List.of(root));
        result.add(List.of(root.val));

        while(!queue.isEmpty()) {

            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : queue.removeFirst()) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                    values.add(node.left.val);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                    values.add(node.right.val);
                }
            }

            if (!nextLevel.isEmpty()) {
                queue.addLast(nextLevel);
                result.add(values);
            }
        }

        return result;
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
