class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int l = 0;
        int r = 0;

        while(l < word.length() && r < abbr.length()) {

            if(abbr.charAt(r) == '0')
                return false;
        
        if(!Character.isDigit(abbr.charAt(r))){
            if(l < word.length() && word.charAt(l) == abbr.charAt(r)) {
                l++;
                r++;
            } else {
                return false;
            }
        }
            else {
                int sublen = 0;
                while(r < abbr.length() && Character.isDigit(abbr.charAt(r))) {
                    sublen = sublen * 10 + (abbr.charAt(r) - '0');
                    r++;
                }
                l = l + sublen;
            }
        }
        return l == word.length() && r == abbr.length();
        }
}

// we can use two pointer is each string
// check is the character are same, if its a number we move the pointer in original string and check for again
// also check for adjacent numbers
// check for zeros
// 

// things to rememeber parse digits froms strings

// understand how to move pointer effectively, for two strings
// if character at abbr is string, keep checking if same word for work
// if not, we know its a number and then we can increment l and r according to the number that is at 


// PRACTICE a lot more, but you got the idea, just couldn't implement