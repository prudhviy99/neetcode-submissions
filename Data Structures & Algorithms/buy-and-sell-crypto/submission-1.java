class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while(r < prices.length) {
            if(prices[r] >= prices[l]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }
}

// use two pointers one for buy day, and one for sell
// set l = 0 and r = 1
// keep moving r, if prices[r] > prices[l], keep track of max profit
// if prices[l] > prices[r], make l = r 
