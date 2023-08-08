/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];

        for(int i = 0; i < LIS.length; i++) LIS[i] = 1;

        for(int i = nums.length -1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        int result = 0;

        for(int i = 0; i < LIS.length; i++) result = Math.max(result, LIS[i]);

        return result;
    }
}