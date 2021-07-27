/*

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*/

// Solution 1
// O(2^n)
// This solution is recursive and the complexity is O(2^n).

class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// Solution 2
// O(n)
// Obviously solution 1 ends up finding the nth fibonacci number so we can abstract it and find the result in O(n) time.
class Solution {
    public int climbStairs(int n) {
        int prev_prev = 1;
        int prev = 2;
        
        if(n == 1) return 1;
        
        for(int i = 0; i < n - 2; i++){
            int current = prev + prev_prev;
            prev_prev = prev;
            prev = current;
        }
        
        return prev;
    }
}