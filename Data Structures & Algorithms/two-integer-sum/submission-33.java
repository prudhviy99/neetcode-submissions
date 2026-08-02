class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create a hash map of nums, index
        // iterate through the loop while doing
        // compliment = target - i;
        // if compliment is in the hashmap, get the index and return index and current index
        // if not add to hashmap

        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (hm.containsKey(compliment)) {
                return new int[] {hm.get(compliment) , i};
            } else {
                hm.put(nums[i] , i);
            }
        }
        return new int[0];
    }
}
