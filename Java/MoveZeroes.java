/*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

*/

// Solution 1
// Time complexity: O(n)

class Solution {
    public void moveZeroes(int[] nums){
    
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] != 0){
                
                nums[index] = nums[i];
                index++;                
            }
 
        }
        
        for(int i = index; i < nums.length; i++) nums[i] = 0;            
    }
}

// Solution 2
// Bad solution
// Time complexity: O(n^logn) since queue insertion is O(nlogn)

class Solution {
    public void moveZeroes(int[] nums){
        
        Queue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) if(nums[i] == 0) q.add(i);
        
        for(int i = 0; i < nums.length; i++) if(nums[i] != 0 && !q.isEmpty() && i > q.peek()){
            nums[q.peek()] = nums[i];
            nums[i] = 0;
            q.remove();
            q.add(i);
        }              
    }
}

