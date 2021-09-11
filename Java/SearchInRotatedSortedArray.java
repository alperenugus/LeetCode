/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

*/

class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length < 2 && target != nums[0]) return -1; 
        
        if(nums.length < 2 && target == nums[0]) return 0; 
        
        int rotationIndex = findRotationIndex(nums, 0, nums.length - 1);
                
        if(rotationIndex == -1){ 
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        
        if(target <= nums[nums.length - 1]){
            return binarySearch(nums, target, rotationIndex, nums.length - 1);
        }
        
        return binarySearch(nums, target, 0, rotationIndex - 1);
    }

    public int findRotationIndex(int[] nums, int left, int right){
        
        if(left < right){
            int mid = (right + left) / 2;

            if(mid > left && nums[mid - 1] > nums[mid]) return mid;

            if(mid < right && nums[mid + 1] < nums[mid]) return mid + 1;

            if(nums[right] > nums[mid]) return findRotationIndex(nums, left, mid - 1);

            return findRotationIndex(nums, mid + 1, right);
        }
        

        return -1;
    }
    
    public int binarySearch(int[] nums, int target, int left, int right){
        
        if(left <= right){
            int mid = (right + left) / 2;
        
            if(nums[mid] == target) return mid;
            
                    
            if(nums[mid] > target) return binarySearch(nums, target, left, mid - 1);
        
            return binarySearch(nums, target, mid + 1, right);
        }
        
        return -1;
    }
}