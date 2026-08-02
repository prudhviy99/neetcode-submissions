class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> ans = new HashMap<>();
    for (String str : strs)
    {
        int[] count = new int[26];
        for ( char c : str.toCharArray()) {
            count[c - 'a']++;
        }
    String key = Arrays.toString(count);
    ans.putIfAbsent(key, new ArrayList<>());
    ans.get(key).add(str);        
    }
    return new ArrayList<>(ans.values());
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

