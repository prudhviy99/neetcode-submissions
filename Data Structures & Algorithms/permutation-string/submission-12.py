class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        s1_count = Counter(s1)
        window_count = Counter()
        start = 0
        k = len(s1)

        for end in range(len(s2)):
            # 1. Add current character to sliding window
            window_count[s2[end]] += 1

            # 2. If window size exceeds k, shrink from left
            if (end - start + 1) > k:
                window_count[s2[start]] -= 1
                if window_count[s2[start]] == 0:
                    del window_count[s2[start]]  # Clean up empty keys so dict comparison works
                start += 1

            # 3. If window size is exactly k and frequencies match, we're done!
            if (end - start + 1) == k and window_count == s1_count:
                return True

        return False

