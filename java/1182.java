import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/shortest-distance-to-target-color/

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int MAX_VALUE = 100000;
        int[][] dp = new int[n][4];

        for (int j = 1; j < 4; j++)
            dp[0][j] = MAX_VALUE;

        dp[0][colors[0]] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 4; j++)
                dp[i][j] = dp[i - 1][j] + 1;

            dp[i][colors[i]] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j < 4; j++)
                dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);

        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int i = q[0], c = q[1];
            if (dp[i][c] >= MAX_VALUE)
                ans.add(-1);
            else
                ans.add(dp[i][c]);
        }

        return ans;
    }
}