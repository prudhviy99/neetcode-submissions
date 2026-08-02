class Solution {
    public int maxProfit(int[] prices) {
        // approach 1 is nested for loops, we for each price, we compared with differnt prices to find the maximum profit 
        // n^2 time complexity

        // better approach is with two pointers
        // increasing days, so for each day is the next sell is day is lower, we move the buy day
        // if not we calculate max profit and keek moving the sell day to check for max profit

        int l = 0;
        int r = 1;
        int max = 0;

        while(r < prices.length) {
            if(prices[l] > prices[r]) {
                l = r;
            } else {
                max = Math.max(max,prices[r] - prices[l]);
            }
            r++;
        }
        return max;
    }
}
