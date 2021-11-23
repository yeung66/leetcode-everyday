// https://leetcode-cn.com/problems/toss-strange-coins/

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n][target + 1];

        dp[0][0] = 1 - prob[0];
        if(target>0)
            dp[0][1] = prob[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] * (1 - prob[i]) + (j == 0 ? 0 : dp[i - 1][j - 1] * prob[i]);
            }
        }

        return dp[n - 1][target];
    }
}