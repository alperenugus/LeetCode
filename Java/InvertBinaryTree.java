/*

Given the root of a binary tree, invert the tree, and return its root.

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

// Time Complexity: O(n)
// Space Complexity: O(h)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        
        TreeNode temp = root.right;
        
        root.right = root.left;
        root.left = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
        
    }
}