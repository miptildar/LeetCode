package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        List<Integer> integers = new Solution().countSmaller(new int[]{ 0,2,1 });
        System.out.println();
    }

    private static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            Node root = new Node();
            root.value = nums[0];
            root.index = 0;

            for (int i = 1; i < nums.length; i++) {
                root = insert(root, nums[i], i);
            }

            Node node = root;
            int[] arr = new int[nums.length];
            while(node != null) {
                arr[node.index] = node.lessThanValue;
                node = node.next;
            }

            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        private Node insert(Node root, int value, int index) {
            Node currentNode = root;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.next == null) {
                        currentNode.lessThanValue++;

                        // insert operation
                        Node newNode = new Node();
                        newNode.index = index;
                        newNode.value = value;
                        newNode.previous = currentNode;
                        currentNode.next = newNode;
                        break;
                    }

                    currentNode.lessThanValue++;
                    currentNode = currentNode.next;
                } else {
                    Node newNode = new Node();
                    newNode.index = index;
                    newNode.value = value;
                    newNode.next = currentNode;


                    if (currentNode.index == root.index) {
                        // new root
                        currentNode.previous = newNode;
                        return newNode;
                    } else {
                        // just inserting in the middle
                        newNode.previous = currentNode.previous;
                        newNode.previous.next = newNode;
                        currentNode.previous = newNode;
                    }

                    break;
                }
            }

            return root;
        }
    }

    static class Node {
        Node next;
        Node previous;
        int value;
        int lessThanValue = 0;
        int index;
    }
}
