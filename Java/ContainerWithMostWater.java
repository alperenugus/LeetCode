/*

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

*/

// Time Complexity: O(n)

class Solution {
    public static int maxArea(int[] height) {

        if(height.length < 2) return 0;
        if(height.length == 2) return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length - 1;

        int maxSoFar = 0;
        
        while(left < right){
            
            int area = (right - left) * Math.min(height[left], height[right]);
            
            if(area > maxSoFar) maxSoFar = area;
            
            if(height[left] < height[right]) left++;
            
            else right--;
            
        }

        return maxSoFar;

    }

}