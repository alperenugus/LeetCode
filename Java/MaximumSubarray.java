/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

*/

// Kadane's Algorithm
// Key points: The subarray will never start or end with a negative number since it will decrease the sum. 
// Having a running_sum variable, one can keep track of the positive sum subarrays and update max accordingly.

class Solution {
    
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int max = Integer.MIN_VALUE;
        
        for(int num: nums){
            if(num > max) max = num;
        }
        
        // Return the biggest negative value if nums consists of only negative numbers
        if(max < 0) return max;
        
        int runningSum = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(runningSum + nums[i] > 0) runningSum = runningSum + nums[i];
            else runningSum = 0;
            
            if(runningSum > max) max = runningSum;
            
        }
        
        return max;   
    }
}