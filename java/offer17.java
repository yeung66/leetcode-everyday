class Solution {
    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }

        int[] ans = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            ans[i] = i + 1;
        }

        return ans;
    }
}