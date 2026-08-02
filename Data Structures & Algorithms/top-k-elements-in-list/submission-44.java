class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>();

        for(int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> fmap.get(a) - fmap.get(b));
    
        for (Map.Entry<Integer, Integer> entry : fmap.entrySet()) {
            minHeap.offer(entry.getKey());
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }

        return res; 
    }
}

// use a min heap
// min heap is binary tree, where each parent node is smaller or equal to its children
// means min-heap will hold the smallest value in head
// in java we use priorityqueue to implement minheap

// create a frequency map with each number and its frequency, and then use the min heap to remove the
// least frequent number based on the k value
// return the elements with frequencies from the minheap, b) -> a[0] - b[0]);$0