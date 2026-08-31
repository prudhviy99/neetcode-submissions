class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # brute force approach is to check every element in the array and keep
        # count of all the numbers in a hashmap into a new list
        # sort the list by count and then return the values of first K elements
        # this will be O(nlogn) 
        
        # better way is to use a min heap to add the frequency map elements in   the heap and
        # and then pop when the size of heap is greater than k
        
        heap = []

        count = {}

        for num in nums:
            count[num] = 1 + count.get(num, 0)

        for num in count.keys():
            heapq.heappush(heap, [count[num], num])
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res
                
        