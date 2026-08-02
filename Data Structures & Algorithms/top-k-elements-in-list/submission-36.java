class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    
    Map<Integer, Integer> fmap = new HashMap<>();
    List<Integer>[] freq = new List[nums.length + 1];

    for(int num : nums){
        fmap.put(num, fmap.getOrDefault(num, 0) + 1);
    }
    
    for(int i = 0; i < freq.length; i++){
        freq[i] = new ArrayList<>();
    }

    for(Map.Entry<Integer, Integer> entry : fmap.entrySet()) {
        freq[entry.getValue()].add(entry.getKey());
    }

    int[] res = new int[k];
    int index = 0;
    for(int i = freq.length - 1;  i > 0 && index < k; i--) {
        for(int f : freq[i]){
            res[index] = f;
            index++;
            if(index == k)
                return res;
        }
    }
    return res;
    }
}

// we can use minHeap and hashmap, add all elements to hashmap with frequencies
// setup priority queue to sort by map.entry. value
// if minheap size is > k, we remove from queue
// after loop use another for loop to return values from minHeap entries

// Better approach with bucket sort
// trick is to have buckets for values in a list of arrays, where the index the number of times each element in the array repeats
// we can start with frequency map
// then create a List of arrays based on the frequency map and add the elements for each frequency index in the list
// finally, we can iterate through the freq list and r
// need to practice this more, you still dont understand shit