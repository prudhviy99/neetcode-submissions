class Solution {
    public int majorityElement(int[] nums) {
    int ans = 0;
    int count = 0;

    for (int num : nums) {
        if (count == 0)
            ans = num;

        if (ans == num)
            count++;
        else
            count--;
    }
    return ans;
    // majority element is the number that appears more then n / 2 times
    // we can use fmap to keep counting the frequencies and keep checking for the condition
    

    // boyer moore algo
    // we can have count and res as 0
    // pass through array using for loop
    // if count = 0, set res as current num
    // keep increment and decrement count when the num is res or num is not result
    }
}