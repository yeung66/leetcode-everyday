class Solution {
    public int findKthNumber(int n, int k) {
        k--;
        int cur = 1;
        while (k > 0) {
            long steps = getSteps(cur, n);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }

        return cur;
    }

    public long getSteps(int curr, int n) {
        long steps = 0;
        long first = curr, last = curr;
        while (first<=n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }

        return steps;
    } 
}