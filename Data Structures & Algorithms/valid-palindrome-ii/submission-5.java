class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while ( l < r ) {
            if(s.charAt(l) != s.charAt(r))
                return checkPalindrome(s, l + 1, r) || checkPalindrome(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }

    public boolean checkPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) 
                return false;
            l++;
            r--;
        }
        return true;
    }
}

// we can use two pointer solution
// during the first pass, while decrement right pointer and incrementing left pointer
// if palindrome check fails, we can call another func to perform a check for 2 cases
// l + 1, r and l , r - 1
// if these check fails we can return false, if not its true