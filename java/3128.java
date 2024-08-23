class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }

        long ans = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    ans += (rowOnes[i] - 1) * (colOnes[j] - 1);
                }
            }
        }

        return ans;
    }
}