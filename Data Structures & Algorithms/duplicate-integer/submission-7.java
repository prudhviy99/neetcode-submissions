class Solution {
    public boolean hasDuplicate(int[] nums) {
        // checking for duplicates, we can obvsly do brute force, but using a hashset will be better approach

        Set<Integer> hs = new HashSet<>();

        for (int num : nums) {
            if(hs.contains(num))
                return true;
            hs.add(num);
        }
        return false;
    }
}