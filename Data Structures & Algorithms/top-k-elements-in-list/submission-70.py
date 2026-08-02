class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        heap = []

        fCount = {} # num -> freq
        for num in nums:
            fCount[num] = 1 + fCount.get(num, 0)

        for num in fCount.keys():
            heapq.heappush(heap, (fCount[num], num))
            if len(heap) > k:
                heapq.heappop(heap)

        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res