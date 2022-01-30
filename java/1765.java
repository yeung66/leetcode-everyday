import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    final int[] dir = new int[] { -1, 0, 1, 0, -1 };

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            var point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i], ny = y + dir[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && isWater[nx][ny] == 0) {
                    board[nx][ny] = board[x][y] + 1;
                    isWater[nx][ny] = 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }

        return board;
    }
}