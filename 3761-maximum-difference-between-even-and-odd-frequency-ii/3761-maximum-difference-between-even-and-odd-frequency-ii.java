class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);

                int cntA = 0, cntB = 0, prevA = 0, prevB = 0;
                int left = -1;

                for (int right = 0; right < n; right++) {
                    if (s.charAt(right) == a) cntA++;
                    if (s.charAt(right) == b) cntB++;

                    while (right - left >= k && cntB - prevB >= 2) {
                        int st = getStatus(prevA, prevB);
                        best[st] = Math.min(best[st], prevA - prevB);
                        left++;
                        if (s.charAt(left) == a) prevA++;
                        if (s.charAt(left) == b) prevB++;
                    }

                    int currentState = getStatus(cntA, cntB);
                    int targetState = currentState ^ 2;  // flip parity of a

                    if (best[targetState] != Integer.MAX_VALUE) {
                        int diff = (cntA - cntB) - best[targetState];
                        ans = Math.max(ans, diff);
                    }
                }
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    private int getStatus(int aCount, int bCount) {
        return ((aCount & 1) << 1) | (bCount & 1);
    }
}
