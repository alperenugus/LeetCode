/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */

// Recursive

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){

            if(amount - coins[i] >= 0){
                int subResult = coinChange(coins, amount - coins[i]);
                if(subResult != -1) min = Math.min(min, 1 + subResult);
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}

// Dynamic Programming
class Solution {

    int[] memo = new int[10001];

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){

            if(amount - coins[i] >= 0){
                int subResult = -1;

                if(memo[amount- coins[i]] != 0){
                    subResult = memo[amount- coins[i]];
                }
                else{
                    subResult = coinChange(coins, amount - coins[i]);
                    memo[amount- coins[i]] = subResult;
                }

                if(subResult != -1) min = Math.min(min, 1 + subResult);
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}