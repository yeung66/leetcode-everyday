// https://leetcode-cn.com/problems/knight-probability-in-chessboard/submissions/
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];

        for (int i=0;i<=k;i++) {
            for (int j=0;j<n;j++) {
                for (int z=0;z<n;z++) {
                    if (i == 0) {
                        dp[i][j][z] = 1;
                    } else {
                        for (var d: dirs) {
                            int nx = j + d[0],  ny = z + d[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                dp[i][j][z] += dp[i-1][nx][ny] / 8;
                            }
                        }
                    }
                }
            }
        }

        return dp[k][row][column];
    }

    final int[][] dirs = new int[][] {{-2,-1}, {-1,-2}, {1, -2},{2,-1},{-2,1},{-1,2},{2,1},{1,2}};
    
}