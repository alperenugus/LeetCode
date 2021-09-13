/*

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        combination(0, target, result, new ArrayList<Integer>(), 0, candidates);
    
        return result;
    }
    
    public void combination(int total, int target, List<List<Integer>> result, List<Integer> currentCombination, int currentIndex, int[] candidates){
        
        if(total == target){
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        if(total > target || currentIndex >= candidates.length) return;
        
        currentCombination.add(candidates[currentIndex]);
            
        combination(total + candidates[currentIndex], target, result, currentCombination, currentIndex, candidates);

        currentCombination.remove(currentCombination.size()-1);

        combination(total, target, result, currentCombination, currentIndex + 1, candidates);
        
    }
    
}