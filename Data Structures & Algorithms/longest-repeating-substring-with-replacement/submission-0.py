class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # have a hashmap to count the frequency of elements in the window
        # use a sliding window 
        # window - max frequency of element < k, this should the condition we keep checking while
        # expanding the window
        # if not remove l from windows

        count = {}
        l = 0

        res = 0

        for r in range(len(s)):
            count[s[r]] = 1 + count.get(s[r], 0)

            if (r - l + 1) - max(count.values()) > k:
                count[s[l]] -= 1
                l += 1
            res = max(res, r - l + 1)
        return res