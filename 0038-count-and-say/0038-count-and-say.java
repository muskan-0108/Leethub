class Solution {
    public String countAndSay(int n) {
        String s = "1";
        // We already have the 1st term. For each next term (2 to n), build from previous.
        for (int k = 2; k <= n; k++) {
            StringBuilder next = new StringBuilder();
            int len = s.length();
            int i = 0;
            while (i < len) {
                char c = s.charAt(i);
                int count = 1;
                i++;
                // Count how many same chars consecutively
                while (i < len && s.charAt(i) == c) {
                    count++;
                    i++;
                }
                // Append “count” then the character
                next.append(count);
                next.append(c);
            }
            s = next.toString();
        }
        return s;
        
    }
}