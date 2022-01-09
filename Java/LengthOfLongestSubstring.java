/*

Given a string s, find the length of the longest substring without repeating characters.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
                
        int result = 0;
        int[] lookUp = new int[256]; 
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            int c = s.charAt(i);
                        
            // We haven't seen this char yet.
            if(lookUp[c] == 0){
                lookUp[c]++;
                right++;
            }
            // Duplicate case
            else{
                                
                lookUp[c]++;

                // Remove all previous characters until removing the duplicate
                while(lookUp[c] == 2){
                    lookUp[s.charAt(left)]--;
                    left++;
                }
                
                right++;
                                
            }
            
            result = Math.max(result, right - left);
            
        }
        
        return result;
        
    }
}