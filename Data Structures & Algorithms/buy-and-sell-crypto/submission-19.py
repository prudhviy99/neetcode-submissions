class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # given an array with prices of stock 
        # brute force is to check every price with other prices in the array and save max profit
        # time will be o(n^2) space will be o(1)

        # optimal will be to use a sliding window
        # start will both pointer at first price,
        # if we find a cheaper day, we move l to that position
        # if we find a profit day, update max profit and expand window
        
        # implementation
        # use l = 0 and use r in for loop through prices
        # create maxp = 0
        # check if r is greater that l, if it is update maxp
        # else move l to r
        # return maxp

        l = 0
        maxp = 0

        for r in range(len(prices)):
            if prices[r] < prices[l]:
                l = r
            else:
                maxp = max(maxp, prices[r] - prices[l])

        return maxp