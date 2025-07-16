class Solution {
    public int maximumLength(int[] nums) {
        int[][] dp = new int[2][2]; // dp[lastParity][expectedParity]
        int ans = 0;

        for (int x : nums) {
            int p = x % 2;
            for (int y = 0; y <= 1; y++) {
                dp[p][y] = dp[y][p] + 1;
                ans = Math.max(ans, dp[p][y]);
            }
        }
        return ans;
    }
}
