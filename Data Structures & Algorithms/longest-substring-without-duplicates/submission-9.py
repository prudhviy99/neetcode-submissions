class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # left pointer starts at 0
        # we use a hashmap to store all indexes
        # we use right pointer to iterate
        # check if hashmap has r value while iterating r
        # if duplicate exists, move l to the last index of r value + 1  
        # ( which we just found a     duplicate)
        
        hmap = {}
        l = 0
        res = 0
        
        for r in range(len(s)):
            if s[r] in hmap:
                l = max(hmap[s[r]] + 1, l) # we dont know if the l is the duplicate, duplicate 
                # might be somewhere in the window
            hmap[s[r]] = r
            res = max(res, r - l + 1)
        
        return res
            