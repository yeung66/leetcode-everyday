class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long prev = 1;
        long ans = 1;
        for (int i = 1; i < n; i++) {
            int cur = 1;
            if (prices[i] - prices[i - 1] == -1) {
                cur += prev;
            }

            ans += cur;
            prev = cur;
        }

        return ans;
    }
}