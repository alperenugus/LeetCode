/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

*/

// O(n)

class Solution {
    public int singleNumber(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int num: nums){
            
            if(set.contains(num)) set.remove(num);
            else set.add(num);            
        }
        
        Iterator<Integer> it = set.iterator();
        
        Integer singleNum = it.next();
        
        return singleNum;
    }
}