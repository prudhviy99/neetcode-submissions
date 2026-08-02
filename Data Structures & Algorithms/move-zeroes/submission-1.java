class Solution {
    public void moveZeroes(int[] nums) {
        // give an integer of nums, we need to move all zeros to the end
        // should be able to maintain the original order
        // we can follow two pointer apporach one pointer to track zeros and one pointer to traverse the array
        // both pointers start at 0, move l when != 0 to keep track of non-zeroes, keep moving r and replace with l when r is non zero

        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            if(nums[r] != 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }
}