class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
    int last = m + n - 1;

    while(m > 0 && n > 0) {
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

// given 2 sorted arrays

// use 3 pointers to add the elements from nums[2] to nums[1]
// since we have sorted arrays, we can start adding elements from the last,
// one pointer at m, one pointer at n and one pointer are last in nums[1]
// if the nums2[n] > nums1[m] , we add nums2 of n to the last and decrement n
// if nums1[m] > nums2[n] , we add nums1[m] to last and decrement m
// regardless of which one we add, we decrement last

// at the end, we add all remaining elements in nums2 in nums1 using last pointer


//practice again and again, no way we are remembering this
// need more practice, you got the idea but thinking through it is still difficult