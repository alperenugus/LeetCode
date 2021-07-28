/*

Given the root of a binary tree, return the inorder traversal of its nodes' values.

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

// Solution 1
// Recursion

class Solution {

    public void inorderRecursion(TreeNode root, List<Integer> result){

        if(root == null) return;
                
        inorderRecursion(root.left, result);
        result.add(root.val);
        inorderRecursion(root.right, result);        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        inorderRecursion(root, result);
        
        return result;
        
    }
}

// Solution 2
// Iteration

