class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # make it a set
        # for each num check if a smaller one exists
        # if not, start a while loop until num + 1 exits and keep increase length
        # compare length with maxlength

        nums = set(nums)
        maxlen = 0
        for num in nums:
            if (num - 1) not in nums:            
                len = 1
                while (num + len) in nums:
                    len += 1
                maxlen = max(len, maxlen)
        return maxlen