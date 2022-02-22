class Solution {
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n <= 1)
            return n;

        int a = 0, b = 1;
        int cnt = 1;
        while (cnt < n) {
            int temp = (a + b) % MOD;
            a = b;
            b = temp;
            cnt++;
        }

        return b;
    }
}