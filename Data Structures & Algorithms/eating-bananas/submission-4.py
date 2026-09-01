class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # binary search
        # lower bound is 1 and upper bound is max value in piles

        l = 1
        r = max(piles)

        while l <= r:
            k = (r + l) // 2

            totalTime = 0
            for p in piles:
                totalTime += math.ceil(float(p) / k)
            
            if totalTime <= h:
                res = k
                r = k - 1
            else:
                l = k + 1
            
        return res
        