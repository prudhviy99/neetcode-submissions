class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # mid will be l + r / 2, l and r are pointers 0 and end of array
        # if target is less than mid, r = mid - 1
        # if target is greater, l = mid + 1
        # if target = mid, return mid

        l = 0
        r = len(nums) - 1

        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
        return -1
        