class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # approach, use sliding window
        # initialize a window set
        # both pointer start at 1
        # while the current window does not have the a duplicate, keep increment r
        # and a window, regular for loop with r
        # if window has duplicate, remove left most from window until  it does not
        # duplicate update window
        # keep track of max window size


        l = 0
        window = set()
        res = 0
        for r in range(len(s)):
            while s[r] in window and l < r:
                window.remove(s[l])
                l += 1
            
            window.add(s[r])
            res = max(res, r - l + 1)
            r += 1
        
        return res
