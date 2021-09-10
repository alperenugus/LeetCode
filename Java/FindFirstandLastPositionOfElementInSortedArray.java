/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 1 && nums[0] == target){
            return new int[]{0, 0};
        }
        
        int[] result = new int[2];
        
        result[0] = findFirstPos(nums, target, 0, nums.length - 1);
        result[1] = findLastPos(nums, target, 0, nums.length - 1);
        
        return result;
    }
    
    
    int findFirstPos(int[] nums, int target, int left, int right){
        
        int leftMost = -1;
        
        while(left <= right){
            
            int mid = (right + left) / 2;
            
            if(nums[mid] == target) leftMost = mid;
            
            if(nums[mid] >= target) right = mid - 1;
            
            else left = mid + 1;
        }
        
        return leftMost;
    }
    
    int findLastPos(int[] nums, int target, int left, int right){
        
        int rightMost = -1;
        
        while(left <= right){
            
            int mid = (right + left) / 2;
            
            if(nums[mid] == target) rightMost = mid;
            
            if(nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        
        return rightMost;
    }
    
}