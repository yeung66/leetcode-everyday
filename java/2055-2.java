class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        int sum = 0;
        for (int i=0;i<n;i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }

        int[] left = new int[n], right = new int[n];
        for (int i=0,l=-1;i<n;i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }

        for (int i=n-1,r=-1;i>=0;i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }

        int[] ans = new int[queries.length];
        for (int i =0;i<queries.length;i++) {
            int[] q = queries[i];
            int leftCan = right[q[0]], rightCan = left[q[1]];
            if (leftCan == -1 || leftCan > q[1] || rightCan == 1 || rightCan < q[0]) ans[i] = 0;
            else {
                ans[i] = preSum[rightCan] - preSum[leftCan];
            }
        }

        return ans;
    }
}