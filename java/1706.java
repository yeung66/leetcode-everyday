class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            int pos = -2;
            while (x < m) {
                if (grid[x][y] == 1 && y + 1 < n && grid[x][y + 1] == 1) {

                    x++;
                    y++;
                    pos = y;
                } else if (grid[x][y] == -1 && y - 1 >= 0 && grid[x][y - 1] == -1) {
                    x++;

                    y--;
                    pos = y;
                } else {
                    pos = -1;
                    break;
                }
            }

            ans[i] = pos;
        }

        return ans;
    }
}