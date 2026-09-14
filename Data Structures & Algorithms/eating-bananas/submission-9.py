class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # binary search

        l = 1
        r = max(piles)
        res = 0

        while r >= l:
            mid = ( l + r ) // 2

            totalTime = 0

            for p in piles:
                totalTime += math.ceil(float(p) / mid)
            
            if totalTime <= h:
                r = mid - 1
                res = mid
            else:
                l = mid + 1
        
        return res
                                                        