package problems;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        //new Solution().inorderTraversal()
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            dfs(root, list);
            return list;
        }

        void dfs(TreeNode node, List<Integer> list) {
            if (node == null)
                return;

            if (node.left != null)
                dfs(node.left, list);
            list.add(node.val);
            if (node.right != null)
                dfs(node.right, list);
        }
    }

    static class TreeNode {
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
