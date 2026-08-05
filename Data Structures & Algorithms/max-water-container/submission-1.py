class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # two pointers one at each end
        # for each iteration, we calculate area and keep the max area 
        # close it pointers by checking which one is smaller
        # return maxarea

        res = 0
        l = 0
        r = len(heights) - 1

        while l < r:
            area = min(heights[l], heights[r]) * (r - l)
            res = max(area, res)

            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1
            
        return res