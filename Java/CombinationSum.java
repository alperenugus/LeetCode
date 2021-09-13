/*

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        combination(target, new ArrayList<Integer>(), 0, result, candidates);
        
        return result;
    }
    
    public void combination(int remainingSum, List<Integer> currentCombination, int currentIndex, List<List<Integer>> result, int[] candidates){
        
        if(remainingSum == 0){
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        if(remainingSum > 0){
            for(int i = currentIndex; i < candidates.length; i++){
            
                remainingSum -= candidates[i];

                currentCombination.add(new Integer(candidates[i]));

                combination(remainingSum, currentCombination, i, result, candidates);

                remainingSum += candidates[i];
                currentCombination.remove(new Integer(candidates[i]));
            
            }
        }
    }
}