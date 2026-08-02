class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>(); // hash map with k num and v as frequency
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1 );
        }
        // this frequency map has key value pairs with key as the number and values as how many times it occurs in num 

        // sorting the hashmap can work
 
        // optimal solution is bucket sort
        // create an an Array of Lists
        // each item in the array should be a list of items that are repeated x times in the input array, where x is the index of the array of lists
        
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int i = 0; i <  buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : fmap.entrySet())
        {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;
        for (int j = buckets.length - 1; j > 0 && counter < k; j--) {
            if ( k == 0 ) {
                break;
            }
            for (int value : buckets[j]) {
                res[counter] = value;
                counter++;
            }
        }
        return res;
    }
}