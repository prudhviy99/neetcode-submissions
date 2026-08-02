class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> res = new HashMap<>();

        for(String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}


// for each string, calculate the count of each alphabet
// need to use that count as the key for a hashmap
// add values in the hashmap for each count key to the result list


// more practice
// STILL DONT UNDERSTAND THE IMPLEMENTATION, understand data structures to use, and how to return the results
// PRACTICE, PRACTICE
