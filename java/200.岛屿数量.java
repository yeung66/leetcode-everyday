import java.util.*;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (55.48%)
 * Likes:    1393
 * Dislikes: 0
 * Total Accepted:    346.9K
 * Total Submissions: 619.5K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * grid[i][j] 的值为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[] dirs = new int[] { -1, 0, 1, 0, -1 };
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    continue;

                ans++;

                Queue<Integer> q = new LinkedList<>();
                q.add(i * n + j);
                grid[i][j] = '0';
                while (!q.isEmpty()) {
                    int cur = q.poll();
                                        
                    // System.out.printf("%d %d\n", cur / n, cur % n);
                    for (var k = 0; k < 4; k++) {
                        int nx = cur / n + dirs[k];
                        int ny = cur % n + dirs[k + 1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                            q.add(nx * n + ny);
                            grid[nx][ny] = '0';
                        }
                    }
                }

            }
        }
        
        return ans;
    }
}
// @lc code=end
