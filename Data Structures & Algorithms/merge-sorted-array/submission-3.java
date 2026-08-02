class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // three pointer approach
        // first pointer is m, last valid value in nums 1
        // n, last value in nums2
        // and new pointer last which is track the last unprocessed value

        // since both are sorted array, we check if m and n and put whichever value is greater last and decrement m or n
        // decrement last regardless

        // edge case is to add any remaining elements in nums2 to last while decrementing both

        int last = m + n - 1;

        while (m > 0 && n > 0) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m--;
            } else {
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }

        while(n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }
}