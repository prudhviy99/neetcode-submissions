class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # tricky tricky
        # brute force is to use nested loop to find a product. simple

        # other options is to use compute sum in one loop and use a division operator 

        # optimal without division:

        # use prefix suffix approach
        # for each element to update the result array with products of elements before that element
        # on a second pass, from back, we update the result array by multiplying with products of elements after the element

        # implementation
        # create result array
        # use 2 loops from first to last for prefix product and last to first for suffix product
        # use prefix and suffix variables to keep track of product and multiple them with current element and add to result array
        # edge case, if more than one zero, the result would be 0s

        res = [1] * len(nums)

        prefix = 1
        for i in range(len(nums)):
            # compute prefix products
            res[i] = prefix
            prefix *= nums[i]
        suffix = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= suffix
            suffix *= nums[i]
        return res