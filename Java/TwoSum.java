/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

*/

// Solution 1
// O(n^2)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }

            }

        }

        return result;

    }
}

// Solution 2
// O(nlogn)

class Solution {

    public static int[] copyArray(int[] from) {

        int[] to = new int[from.length];

        for (int i = 0; i < to.length; i++) {
            to[i] = from[i];
        }

        return to;

    }

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        int num1 = 0;
        int num2 = 0;

        int[] notChanged = copyArray(nums);

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] == target) {
                num1 = nums[left];
                num2 = nums[right];
                break;
            } else if (nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }

        boolean firstFound = false;
        boolean secondFound = false;

        for (int i = 0; i < notChanged.length; i++) {
            if (notChanged[i] == num1 && !firstFound) {
                result[0] = i;
                firstFound = true;
            }

            if (notChanged[i] == num2 && !secondFound && result[0] != i) {
                result[1] = i;
                secondFound = true;
            }
        }

        return result;

    }

}

// Solution 3
// O(n)

class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> numIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (numIndex.containsKey(target - nums[i])) {

                result[0] = numIndex.get(target - nums[i]);
                result[1] = i;
                break;
            }

            else {
                numIndex.put(nums[i], i);
            }
        }

        return result;

    }
}
