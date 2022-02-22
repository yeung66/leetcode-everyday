class Solution {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }

        final int MOD = 1000000007;
        
        int prev1 = 1, prev2 = 1, cnt = 1;
        while (cnt < n) {
            int temp = (prev1 + prev2) % MOD;
            prev1 = prev2;
            prev2 = temp;
            cnt++;
        }

        return prev2;
    }
}