class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # use sliding window
        # have a buy day and sell day as pointer
        # if we find profit, we update max profit and move sell day
        # if we find loss, move sell day
        # return max p

        maxP = 0
        l = 0
        r = 1

        for r in range(len(prices)):
            profit = prices[r] - prices[l]
            if prices[r] > prices[l]:
                maxP = max(maxP, profit)
            else:
                l = r
            
        return maxP

        