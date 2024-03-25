class Solution {
    public boolean oneEditAway(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++)
            for (int j = 0; j <= second.length(); j++)
                dp[i][j] = Integer.MAX_VALUE;
    
        dp[0][0] = 0;
        for (int i = 1; i <= first.length(); i++)
            dp[i][0] = i;
        for (int j = 1; j <= second.length(); j++)
            dp[0][j] = j;

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                else
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }

        return dp[first.length()][second.length()] <= 1;
    }
}