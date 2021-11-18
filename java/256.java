

class Solution {
    // public int minCost(int[][] costs) {
    //     ans = Integer.MAX_VALUE;
    //     for (int c = 0; c < 3; c++) {
    //         dfs(costs, 0, c, 0);
    //     }
    //     return ans;
    // }

    // int ans;

    // public void dfs(int[][] costs, int cur, int color, int prevCost) {
    //     if (cur == costs.length) {
    //         ans = Math.min(ans, prevCost);
    //         return;
    //     }

    //     dfs(costs, cur + 1, (color + 1) % 3, prevCost + costs[cur][color]);
    //     dfs(costs, cur + 1, (color + 2) % 3, prevCost + costs[cur][color]);
    // }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            int dp0 = Math.min(dp[1], dp[2]) + costs[i][0];
            int dp1 = Math.min(dp[0], dp[2]) + costs[i][1];
            int dp2 = Math.min(dp[1], dp[0]) + costs[i][2];
            dp[0] = dp0;
            dp[1] = dp1;
            dp[2] = dp2;
        }

        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }

    
}