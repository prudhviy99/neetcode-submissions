class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        // you need to start from first so pointers should be zero and condition should be less than lengths or strings
        
        int i = 0;
        int n = word.length();
        int j = 0;
        int m = abbr.length();

        while(i < n && j < m) {
            if(abbr.charAt(j) == '0') 
                return false;

            if(Character.isLetter(abbr.charAt(j))) {
                if(i < n && word.charAt(i) == abbr.charAt(j)){
                    i++;
                    j++;
                } else {
                    return false;
                }

            } else {
                int sublen = 0;
                while(j < m && Character.isDigit(abbr.charAt(j))) {
                    sublen = sublen * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i = i + sublen;
            }
        }
        if( i == n && j == m)
            return true;
        else 
            return false;
    }
}

// we can use two pointer is each string
// check is the character are same, if its a number we move the pointer in original string and check for again
// also check for adjacent numbers
// check for zeros
// 

// things to rememeber parse digits froms strings



// PRACTICE a lot more, but you got the idea, just couldn't implement