/*

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

*/

// Key points: Sliding window. In each iteration, check if the profit is bigger than the previous. If found a lower price, update minPrice.

class Solution {
    
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int minPrice = prices[0];
        
        for(int price : prices){
            if(price - minPrice > profit) profit = price - minPrice;
            if(price < minPrice) minPrice = price;
        }
        
        return profit;
    }
}