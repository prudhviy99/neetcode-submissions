class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.offer(n);
            if(minHeap.size() > k)
                minHeap.poll();
           
        }
        return minHeap.peek();
    }
}

// sorting is easy solution
// we can use Min-Heap for O(n log k ) solution 

// we can use quick select for better solution o(n) or o(n^2) worst case