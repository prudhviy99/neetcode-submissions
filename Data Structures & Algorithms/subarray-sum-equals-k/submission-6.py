class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # prefix sum hashmap to save the counts of each sum computed so far
        # sum : count
        # if sum - k is in the hashmap, we know that the there a subarray that sum upto to k


        res = 0

        prefix_sum = { 0 : 1 }
        currSum = 0

        for num in nums:
            currSum += num


            res += prefix_sum.get(currSum - k , 0)

            prefix_sum[currSum] = 1 + prefix_sum.get(currSum, 0)

            
        return res