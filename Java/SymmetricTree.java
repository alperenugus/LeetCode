/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

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

// Key point: Inorder traversal is not a correct approach since inorder traversal does not guarantee that both trees have the exact same structure.
// Iterative solution can be implemented using a queue, adding the root twice at the beginning and adding elements symmetrically.

class Solution {

    public boolean isSymmetric(TreeNode root) {
            return check(root, root);
    }
    
    public boolean check(TreeNode root1, TreeNode root2){
        
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        
        return root1.val == root2.val && check(root1.right, root2.left) && check(root1.left, root2.right);
        
    }
    
}