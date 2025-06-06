class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        
        int hLen = haystack.length();
        int nLen = needle.length();

        for (int i = 0; i <= hLen - nLen; i++) {
            int j;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return i;  // Found needle starting at index i
            }
        }
        return -1;
    }
}
