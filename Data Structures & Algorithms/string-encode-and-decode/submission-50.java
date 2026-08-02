class Solution {

    // encode

    // give a list of strings
    // find the length of each string
    // choose a random char as the distinguisher
    // concat the strings into a single string, but add two character elements to each string before concating
    // first char should be the length of the string and second char should be distinguisher ( lets choose $ ) 
    // return the encoded string

    // decode 
    // tricky part
    // initialize a char variable and assign the distinguisher used when encoding
    // Start with first index which will be the length of first string, proceed to parse the string until the distinguisher to find the actual length of the first string, let call it len
    // confirm the char adjacent to the current will be the distinguisher
    // move the index len + 1 while adding the elements from current index + 1 to destination
    // reset len integer with the current index if its not null, if null we can break and return result
    // confirm if the next char in the string is equal to dist
    // repeat

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString(); // example encoded string 5$Hello5$World12$howisitgoing
        //                                                   0123456789 
    }

    public List<String> decode(String str) {
       List<String> res = new ArrayList<>();
       int i = 0;
       while (i < str.length()) {
        int j = i;
        while(str.charAt(j) != '#') {
            j++;
        }
        int currentLength = Integer.parseInt(str.substring(i,j));
        i = j + 1;
        j = i + currentLength;
        res.add(str.substring(i,j));
        i = j;
       }
       return res;
    }
}
