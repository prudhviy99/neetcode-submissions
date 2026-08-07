class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # given nums, return the longest consecutive length of number that be formed

        # brute force, for every element we can check if + 1 exists using nested loop

        # optimal 
        # make it into a set
        # for every num check if n - 1 exists in the set, if not continue
        # if exists, start a while loop until n + length exists and increment length
        # return length

        nums = set(nums)

        len = 0

        for n in nums:
            currlen = 1
            if n - 1 in nums:
                continue
            while (n + currlen) in nums:
                currlen += 1
            len = max(currlen, len)
        return len