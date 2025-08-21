class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int ans = 0;

        for (int r = 0; r < m; r++) {
            // Step 1: Update histogram heights
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 1) {
                    heights[c] += 1;
                } else {
                    heights[c] = 0;
                }
            }

            // Step 2: Use monotonic stack to count rectangles ending at this row
            Stack<Integer> stack = new Stack<>();
            int[] sumInRow = new int[n];

            for (int c = 0; c < n; c++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[c]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    int prev = stack.peek();
                    sumInRow[c] = sumInRow[prev] + heights[c] * (c - prev);
                } else {
                    sumInRow[c] = heights[c] * (c + 1);
                }

                stack.push(c);
                ans += sumInRow[c];
            }
        }
        return ans;
    }
}
