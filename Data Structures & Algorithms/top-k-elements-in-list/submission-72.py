class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # approach is to use a freq map with num -> freq 
        # and then use a heap freq -> num, and then pop is heap size is greater than k

        fmap = {} 
        for num in nums:
            fmap[num] = 1 + fmap.get(num, 0)
        
        res = []

        heap = []
        for num in fmap.keys():
            heapq.heappush(heap, (fmap.get(num), num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])

        return res