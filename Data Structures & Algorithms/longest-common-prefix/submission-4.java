class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        for(int i = 0; i < strs[0].length(); i++) {
            for(String s : strs) {
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i))
                    return s.substring(0,i);
            }
        }
        return strs[0];
    }
}

// vertical scaling
// have a nested loop, for loop until length of first string use i
// nexted loop will loop through all strings and check if str(i) is equal for each string

// prefixes, so we can start from first
// brute force is to take the first word and delete character in the first string until it match with next string in the loop
// I think brute force can be done with one pass if we initialize a new string with first word and keep deleting the rest
// maybe another optimal way to do it? 

// 
// sort the strings using Arrays.sort
// 

// contraints : strings can be empty, is empty we can return empty output