package io.shashanktyagi;

public class BestTimetoBuyandSellStock {
    static public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            int profit = 0;
            int max = prices[prices.length - 1];
            for (int i = prices.length - 1; i >= 0; i--) {
                if (prices[i] > max) {
                    max = prices[i];
                } else {
                    profit = Math.max(max - prices[i], profit);
                }
            }
            return profit;
        }
    }
}
