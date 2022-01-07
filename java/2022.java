// https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int M = original.length;
        if (M != m * n) {
            return new int[0][0];
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < M; i++) {
            int x = i / n;
            int y = i % n;
            ans[x][y] = original[i];
        }

        return ans;
    }
}