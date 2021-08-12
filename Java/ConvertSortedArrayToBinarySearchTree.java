/*

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

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
// Space Complexity: O(h) for recursion call stack, where h is the height of the tree.

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
            
        TreeNode head = sortedArrayToBSTRecursion(nums, 0, nums.length - 1);
        
        return head;
    }
    
    public TreeNode sortedArrayToBSTRecursion(int[] nums, int start, int end){
        
        if(start > end) return null;
        
        int mid = (end + start) / 2;
  
        TreeNode node = new TreeNode(nums[mid]);
        
        
        node.left = sortedArrayToBSTRecursion(nums, start, mid - 1);
        node.right = sortedArrayToBSTRecursion(nums, mid + 1, end);

        return node;    
    }
    
}