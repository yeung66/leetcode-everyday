import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<long[], Long> cache;

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (var i = n - 1; i >= 0; i--) {
            var q = questions[i];
            var j = i + q[1] + 1;
            dp[i] = Math.max(dp[i + 1], q[0] + (j >= n ? 0 : dp[j]));
        }

        return dp[0];
    }

}