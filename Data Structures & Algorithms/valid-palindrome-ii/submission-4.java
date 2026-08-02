class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while( l < r ) {
            if(s.charAt(r) != s.charAt(l))
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            r--;
            l++;
        }

        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(r) != s.charAt(l))
                return false;
            r--;
            l++;
        }
        return true;
    }
}

// first check palindrome using two pointer approach
// if any of the check fails when comparing l and r
// we have two options
// l + 1, r substring 
// l , r - 1 substring
// have another method to check the palidrome for substring


// figure out which one to delete
// check palindrome
// we still use the two pointer approach but we need to try two case if the match fails between two pointers
// first case is to move check l+1, second is to checkcheck r-1
// basically, we just send two possible substrings after deleting one element, so the finally, we decide if one of the substring is palindrome or not to make final decision
// the helper method is one time run only, we return true or false after checking substring