/*
    Given a string s, find the length of the longest substring without repeating characters.
*/

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    
    let max = 0;
    if(s.length === 1) return 1;
    
    for(let i = 0; i < s.length; i++){
        
        let seen = new Map();
        
        seen.set(s[i], i);
        
        for(let j = i+1; j < s.length; j++){
            
            if(!seen.get(s[j])){
                seen.set(s[j], j);         
                if(seen.size > max ) max = seen.size;
            }
            else break;
        }
    }
    
    return max; 
};

console.log(lengthOfLongestSubstring(" "));