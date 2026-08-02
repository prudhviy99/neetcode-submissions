class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastseen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(lastseen.containsKey(nums[i])) {
                if(i - lastseen.get(nums[i]) <= k) {
                    return true;
                }
            }
            lastseen.put(nums[i], i);
        }
        return false;
    }
}

// need to keep track of index for last seen of each number
// if the number is present in the hashmap, we can return the old index and the new index
