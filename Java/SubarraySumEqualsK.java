/*

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

*/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int counter = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            
            sum += i;
            
            if(sum == k) counter++;
            
            if(map.containsKey(sum - k)){
                
                counter += map.get(sum - k);
                
            }
            
            map.merge(sum, 1,  (current, one) -> current + one);
            
        }
        
        return counter;
        
    }
}