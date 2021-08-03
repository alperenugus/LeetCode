/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

*/

// Complexity: O(n^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                
        Set<List<Integer>> resultSet = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();

        // {num, index} pairs
        // O(n)
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        // O(n^2)
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                int twoSum = nums[i] + nums[j];

                // Complement
                int needed = twoSum * -1;

                // Map has the needed num, i != j != needed.index
                if(map.containsKey(needed) && map.get(needed) != i && map.get(needed) != j && i != j){
                    List<Integer> threeSum = new ArrayList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[j]);
                    threeSum.add(nums[map.get(needed)]);
                    // Two have all unique sub arrays, sorting needed
                    // Does not add additional complexity since the threeSum is guaranteed to have only 3 elements
                    Collections.sort(threeSum);
                    resultSet.add(threeSum);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // From set to ArrayList
        // O(n)
        for(List<Integer> subList : resultSet) result.add(subList);

        return result;
                
    }
}