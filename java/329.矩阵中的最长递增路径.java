/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 *
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (48.91%)
 * Likes:    556
 * Dislikes: 0
 * Total Accepted:    60K
 * Total Submissions: 122.6K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4 
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4 
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：matrix = [[1]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        cache = new int[m][n];

        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    int m;
    int n;
    int[][] cache;

    public int dfs(int[][] matrix, int x, int y) {
        if (cache[x][y] != 0)
            return cache[x][y];

        int[] dir = new int[] { -1, 0, 1, 0, -1 };
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i];
            int ny = y + dir[i + 1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[x][y] < matrix[nx][ny]) {
                ans = Math.max(ans, 1 + dfs(matrix, nx, ny));
            }
        }
        
        cache[x][y] = ans;
        return ans;
    }
}
// @lc code=end

