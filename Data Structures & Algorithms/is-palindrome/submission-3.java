class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;


        while(l <= r) {

            while(l < r && !isAlphaNum(s.charAt(l))) {
                l++;
            }
            while(r > l && !isAlphaNum(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(r)) != Character.toLowerCase(s.charAt(l))) 
                return false;

            r--;
            l++;
        }
        return true;
    }

    public boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
            c >= 'a' && c <= 'z' ||
            c >= '0' && c <= '9');
    }
}
