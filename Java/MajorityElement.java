/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

*/

// Solution 1
// Time complexity: O(nlogn)
// Space complexity: O(1)
// Key point: If an element repeats more than ⌊n / 2⌋ times, if the array is sorted, the middle element should be it. 

class Solution {
    public int majorityElement(int[] nums) {
        
        Arrays.sort(nums);
        
        return nums[nums.length / 2];
        
    }
}

// Solution 2
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int num: nums){
            
            if(count.containsKey(num)) count.put(num, count.get(num) + 1);
            else count.put(num, 1);
        }
        
        int repeatCount = 0;
        int mostSeen = 0;
        
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(entry.getValue() > repeatCount){
                repeatCount = entry.getValue();
                mostSeen = entry.getKey();
            }
        }
        
        return mostSeen; 
    }
}

