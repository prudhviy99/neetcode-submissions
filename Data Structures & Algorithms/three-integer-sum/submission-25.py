class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # sort the list first, pass through array from start to end 
        # for each element, check with 2 more elements using two pointers
        # two pointer starting from i + 1 to end of the list 
        # compare 3 elements and follow the same approach as 2 sum II

        res = []
        nums.sort()

        for i in range(len(nums)):
            l = i + 1
            r = len(nums) - 1

            if nums[i] > 0:
                break
            
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            while l < r:
                currSum = nums[i] + nums[l] + nums[r]

                if currSum == 0:
                    res.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                elif currSum > 0:
                    r -= 1
                else:
                    l += 1
            
            
            
        return res

        