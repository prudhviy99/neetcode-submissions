class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # we need to have a monotonic queue

        dq = deque()
        result = []

        for right, value in enumerate(nums):

            while dq and dq[0] <= right - k:
                dq.popleft()
            
            while dq and nums[dq[-1]] <= value:
                dq.pop()

            dq.append(right)

            if right >= k - 1:
                result.append(nums[dq[0]])
        
        return result