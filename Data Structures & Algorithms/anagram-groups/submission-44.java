class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Boolean[] used = new Boolean[strs.length];
        for ( int i = 0; i < strs.length; i ++) {
            if ( used[i] != null) {
                continue;
            }
            List<String> sublist = new ArrayList<>();
            sublist.add(strs[i]);
            for (int j = i+1; j < (strs.length); j++) {
                if (isAnagram(strs[i], strs[j])) {
                    sublist.add(strs[j]);
                    used[j] = true;
                }
            }
                if(sublist != null) {
                    ans.add(sublist);
                }
                used[i] = true;
        }
        return ans;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sCount.equals(tCount);
    }

    //APPROACH 1
    // first approach brute force
    // create list of list of strings 
    // pass through the array of strings first and check isAnagram for all other strings if yes create a List and add the list of the List of strings after each iteration.

    // problems 
    //duplicate groups will be created.


    //APPROACH 2

    //create hashmap with hashmaps which has character counts of each string. in this hashmap key is 
    // first iteration through array of strings
    // for each string calculate hashmap of character counts and check if the hashmap has it 
}

