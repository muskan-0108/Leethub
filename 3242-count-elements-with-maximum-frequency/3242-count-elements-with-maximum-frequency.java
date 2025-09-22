class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each number
        int maxFreq = 0;
        for (int x : nums) {
            int count = freq.getOrDefault(x, 0) + 1;
            freq.put(x, count);
            maxFreq = Math.max(maxFreq, count); // Track max on the fly
        }

        // Sum frequencies of numbers with max frequency
        int result = 0;
        for (int count : freq.values()) {
            if (count == maxFreq) {
                result += count;
            }
        }

        return result;
        
    }
}