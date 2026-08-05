class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # approach, we use two pointers, but first we need to sort nums
        # after sorting if current is > 0 we return empty, cause sum will be greater
        # than zero
        # during one pass, we check if next element is not the same
        # and calculate 3 sum for curr, l and r pointers, if zero append to result
        # move pointers inward and skip duplicates on left pointer

        nums.sort()
        res = []
        for i, a in enumerate(nums):
            if a > 0:
                break
            # skip if current element is same as before
            if i > 0 and a == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1
            while l < r:
                threeSum = a + nums[l] + nums[r]

                if threeSum > 0:
                    r -= 1
                elif threeSum < 0:
                    l += 1
                else:
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1
        return res

            