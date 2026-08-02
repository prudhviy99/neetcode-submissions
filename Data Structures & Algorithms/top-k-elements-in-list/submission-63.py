class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # frequency map for have (freq, num)
        fmap = {}

        for n in nums:
            fmap[n] = 1 + fmap.get(n, 0)

        # iterate through the freq and add them to min heap, pop heapq is heapsize > k

        heap = []
        for c in fmap.keys():
            heapq.heappush(heap, (fmap[c], c))
            if len(heap) > k:
                heapq.heappop(heap)
        res = []

        for i in range(k):
            res.append(heapq.heappop(heap)[1])

        return res