class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE,  res = 0;
        for (int[] p: pairs) {
            if (cur < p[0]) {
                cur = p[1];
                res++;
            }
        }

        return res;
    }
}