class Solution {
    public int distinctSubseqII(String s) {
        int[] g = new int[26];
        int MOD = 1000000007;
        int total = 0;
        for (int i=0;i<s.length();i++) {
            int oi = s.charAt(i) - 'a';
            int prev = g[oi];
            g[oi] = (total + 1) % MOD;
            total = ((total + g[oi] - prev) % MOD + MOD) % MOD;
        }

        return total;
    }
}