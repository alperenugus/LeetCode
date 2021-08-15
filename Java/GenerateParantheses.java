/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        
        if(n < 0) return null;
        
        List<String> results = new ArrayList<>();
        
        String str = new String();
        
        generateRecursive(results, 2 * n, 0, 0, str);
        
        return results;
        
    }
    
    public void generateRecursive(List<String> results, int n, int open, int close, String str){
        
        if(str.length() == n){
            results.add(str);
            return;
        } 
        
        else{
            
            if(open < n / 2) generateRecursive(results, n, open+1, close, str.concat("("));
            
            if(open > close) generateRecursive(results, n, open, close+1, str.concat(")"));
            
        } 
    }
    
}