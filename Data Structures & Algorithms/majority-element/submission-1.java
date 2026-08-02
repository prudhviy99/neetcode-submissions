class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num,0) + 1);
        }

        int n = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : fmap.entrySet()) {
            if (entry.getValue() > n)
                return entry.getKey();
        }
        return -1;
    }
}