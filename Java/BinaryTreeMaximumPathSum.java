/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        helper(root);

        return max;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));

        max = Math.max(max, leftSum + root.val + rightSum);

        return Math.max(leftSum, rightSum) + root.val;
    }
}