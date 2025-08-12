class Solution {
    public int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1; // sum = 0 banane ka ek hi tarika hai (kuch na lo)

        int a = 1;
        while (true) {
            int power = (int) Math.pow(a, x);
            if (power > n) break;

            // reverse loop to avoid reusing same number
            for (int i = n; i >= power; i--) {
                dp[i] = (dp[i] + dp[i - power]) % MOD;
            }
            a++;
        }

        return dp[n];
    }
}
