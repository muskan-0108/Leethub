public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // Remove trailing and leading spaces
        
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // Length of last word is from lastSpaceIndex+1 to end of string
        return s.length() - lastSpaceIndex - 1;
    }
}
