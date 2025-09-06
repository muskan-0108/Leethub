class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Row check
                    if (!seen.add(num + " in row " + i)) return false;
                    // Column check
                    if (!seen.add(num + " in col " + j)) return false;
                    // Box check
                    if (!seen.add(num + " in box " + (i/3) + "-" + (j/3))) return false;
                }
            }
        }
        return true;
    }
}
