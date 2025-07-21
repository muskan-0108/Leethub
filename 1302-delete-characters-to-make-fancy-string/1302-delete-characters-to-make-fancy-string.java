class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // count of consecutive characters
        
        result.append(s.charAt(0)); // always include the first character
        
        for (int i = 1; i < s.length(); i++) {
            // if current character is same as previous, increment count
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // reset count if new character appears
                count = 1;
            }
            
            // if count < 3, it is allowed to be added
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
