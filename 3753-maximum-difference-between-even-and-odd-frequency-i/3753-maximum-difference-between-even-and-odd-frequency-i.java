class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];  // For 'a' to 'z'

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;

        // Identify max odd and min even frequencies
        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 1) {
                    maxOdd = Math.max(maxOdd, f);
                } else {
                    minEven = Math.min(minEven, f);
                }
            }
        }

        // Return difference
        return maxOdd - minEven;
    }
}
