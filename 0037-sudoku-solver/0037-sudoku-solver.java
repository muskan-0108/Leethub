class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    // try placing digits '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';  // backtrack
                        }
                    }
                    // if no digit fits, backtrack
                    return false;
                }
            }
        }
        // no empty cell found => solved
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        int blockRow = (row / 3) * 3;
        int blockCol = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            // check same row
            if (board[row][i] == c) return false;
            // check same column
            if (board[i][col] == c) return false;
            // check 3×3 block
            int br = blockRow + i / 3;
            int bc = blockCol + i % 3;
            if (board[br][bc] == c) return false;
        }
        return true;
    }
}
