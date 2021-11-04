import java.util.*;
/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 *
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/description/
 *
 * algorithms
 * Hard (48.50%)
 * Likes:    523
 * Dislikes: 0
 * Total Accepted:    23K
 * Total Submissions: 39.9K
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 
 * 
 * 输入: heightMap =
 * [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 10^4
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2)
            return 0;

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    visited[i][j] = true;
                    pq.offer(new int[] { i * n + j, heightMap[i][j] });
                }
            }
        }

        int[] dir = new int[] { -1, 0, 1, 0, -1 };
        int ans = 0;
        while (!pq.isEmpty()) {
            var cur = pq.poll();
            for (var d = 0; d < 4; d++) {
                var nx = cur[0] / n + dir[d];
                var ny = cur[0] % n + dir[d + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (cur[1] > heightMap[nx][ny]) {
                        ans += cur[1] - heightMap[nx][ny];
                    }
                    pq.offer(new int[] { nx * n + ny, Math.max(cur[1], heightMap[nx][ny]) });
                    visited[nx][ny] = true;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

