class Solution {
    public int countDigitOne(int n) {
        long k = 1;
        int cnt = 0;
        for (;n >= k;k*=10) {
            cnt += (n / (10*k) * k) + Math.min(k, Math.max((n % (10*k) - k) + 1, 0));
        }

        return cnt;

    }
}