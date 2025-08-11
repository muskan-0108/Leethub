class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;

        // Step 1: Extract powers of two from n
        List<Integer> powers = new ArrayList<>();
        int bitValue = 1;
        int temp = n;
        while (temp > 0) {
            if ((temp & 1) == 1) {
                powers.add(bitValue);
            }
            bitValue <<= 1;  // move to next power of two
            temp >>= 1;      // check next bit
        }

        // Step 2: Answer queries
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];
            long prod = 1; // use long to avoid overflow before modulo

            for (int i = l; i <= r; i++) {
                prod = (prod * powers.get(i)) % MOD;
            }
            result[q] = (int) prod;
        }

        return result;
        
    }
}