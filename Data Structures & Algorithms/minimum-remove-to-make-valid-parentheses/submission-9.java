class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int[] remove = new int[s.length()];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            } else if( s.charAt(i) == ')') {
                if(!st.isEmpty()) {
                    st.pop();
                } else {
                    remove[i] = 1;
                }
            } 
        }
        
        while(!st.isEmpty()) {
            remove[st.pop()] = 1;
        }

        for(int i = 0; i < remove.length; i++) {
            if(remove[i] != 1)
                res.append(s.charAt(i));
        }
        return res.toString();
    }
}

// basically, the idea is to count the open brackets and use stack to match with closed ones
// remaining brackets should be replaced with a invalid char, we can also use a remove[] array to mark invalid indexes
// the invalid string should be removed and the rest of the string should be appended