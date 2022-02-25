class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    ans = ans || dfs(board, i, j, visited, word, 1);
                    visited[i][j] = false;
                }

                if (ans) {
                    return true;
                }
            }
        }

        return ans;
    }

    final int[] dirs = new int[] { -1, 0, 1, 0, -1 };

    public boolean dfs(char[][] board, int x, int y, boolean[][] visited, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        // System.out.printf("%d %d %d\n", x, y, idx);

        int m = board.length, n = board[0].length;
        boolean ans = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i], ny = y + dirs[i + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == word.charAt(idx)) {
                visited[nx][ny] = true;
                ans = ans || dfs(board, nx, ny, visited, word, idx + 1);
                visited[nx][ny] = false;
            }
        }

        return ans;
    }
}