// https://leetcode-cn.com/problems/longest-line-of-consecutive-one-in-matrix/

class Solution {
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0)
            return 0;

        int m = mat.length, n = mat[0].length;
        int[][][] dp = new int[m][n][4];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    continue;

                dp[i][j][0] = j == 0 ? 1 : dp[i][j - 1][0] + 1;
                dp[i][j][1] = i == 0 ? 1 : dp[i - 1][j][1] + 1;
                dp[i][j][2] = (i == 0 || j == 0) ? 1 : dp[i - 1][j - 1][2] + 1;
                dp[i][j][3] = (i == 0 || j == n - 1) ? 1 : dp[i - 1][j + 1][3] + 1;

                ans = Math.max(ans, Math.max(dp[i][j][0],
                        Math.max(dp[i][j][1],
                        Math.max(dp[i][j][3],dp[i][j][2]))));
            }
        }

        return ans;
    }
}