class Solution {
    public int majorityElement(int[] nums) {
    
    Map<Integer, Integer> fmap = new HashMap<>();

    for(int num : nums) {
        fmap.put(num, fmap.getOrDefault(num, 0) + 1);
    }

    int ans = 0;
    for(Map.Entry<Integer, Integer> entry : fmap.entrySet()) {
        if(entry.getValue() > nums.length / 2)
            ans = entry.getKey(); 
    }

    return ans;
    // majority element is the number that appears more then n / 2 times
    // we can use fmap to keep counting the frequencies and keep checking for the condition
    
    }
}