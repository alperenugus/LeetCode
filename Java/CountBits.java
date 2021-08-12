/*

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

*/

// Time Complexity: O(n)

class Solution {
    public int[] countBits(int n) {
        
        int[] result = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++){
            
            if(i % 2 != 0){
                result[i] = result[i - 1] + 1;
            }
            
            else{
                result[i] = result[i / 2];
            }
            
        }
        
        return result;
    }
}