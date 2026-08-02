class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // first we need a frequency map, with the each nums and its count
        // for topk frequent elements, we can use the approach to have a frequency list array, where index will be the times each number appears    
        Map<Integer, Integer> fmap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num , 0 ) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : fmap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length - 1 ; i > 0 && index < k; i--) {
            for(int f : freq[i]) {
                res[index] = f;
                index++;
                if( index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}