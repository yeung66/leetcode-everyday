import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1036 lang=java
 *
 * [1036] 逃离大迷宫
 *
 * https://leetcode-cn.com/problems/escape-a-large-maze/description/
 *
 * algorithms
 * Hard (29.90%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    17.5K
 * Total Submissions: 37.1K
 * Testcase Example:  '[[0,1],[1,0]]\n[0,0]\n[0,2]'
 *
 * 在一个 10^6 x 10^6 的网格中，每个网格上方格的坐标为 (x, y) 。
 * 
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked
 * 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * 
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 * 
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 * 
 * 示例 2：
 * 
 * 
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * blocked[i].length == 2
 * 0 i, yi < 10^6
 * source.length == target.length == 2
 * 0 x, sy, tx, ty < 10^6
 * source != target
 * 题目数据保证 source 和 target 不在封锁列表内
 * 
 * 
 */

// @lc code=start
class Solution {
    static final int BOUNDERY = 1000000;
    static final int[] dirs = new int[] { -1, 0, 1, 0, -1 };

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return true;
        }

        TreeSet<Integer> rows = new TreeSet<>();
        TreeSet<Integer> cols = new TreeSet<>();
        for (int[] pos : blocked) {
            rows.add(pos[0]);
            cols.add(pos[1]);
        }

        rows.add(source[0]);
        rows.add(target[0]);
        cols.add(source[1]);
        cols.add(target[1]);

        Map<Integer, Integer> rMapping = new HashMap<>();
        Map<Integer, Integer> cMapping = new HashMap<>();

        int firstRow = rows.first();
        int rIdx = (firstRow == 0 ? 0 : 1);
        int prevRow = firstRow;
        rMapping.put(firstRow, rIdx);
        for (int r : rows) {
            if (r == firstRow) {
                continue;
            }

            rIdx += (r == prevRow + 1 ? 1 : 2);
            rMapping.put(r, rIdx);
            prevRow = r;
        }

        if (prevRow != BOUNDERY - 1) {
            rIdx++;
        }

        int firstCol = cols.first();
        int cIdx = (firstCol == 0 ? 0 : 1);
        int prevCol = firstCol;
        cMapping.put(firstCol, cIdx);
        for (int c : cols) {
            if (c == firstCol) {
                continue;
            }

            cIdx += (c == prevCol + 1 ? 1 : 2);
            cMapping.put(c, cIdx);
            prevCol = c;
        }

        if (prevCol != BOUNDERY - 1) {
            cIdx++;
        }

        int[][] grid = new int[rIdx + 1][cIdx + 1];
        for (int[] pos : blocked) {
            int x = pos[0], y = pos[1];
            grid[rMapping.get(x)][cMapping.get(y)] = 1;
        }

        int sx = rMapping.get(source[0]), sy = cMapping.get(source[1]);
        int tx = rMapping.get(target[0]), ty = cMapping.get(target[1]);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { sx, sy });
        grid[sx][sy] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];               

                if (nx >= 0 && nx <= rIdx && ny >= 0
                        && ny <= cIdx && grid[nx][ny] == 0) {
                    if (nx == tx && ny == ty) {
                        return true;
                    }

                    queue.offer(new int[] { nx, ny });
                    grid[nx][ny] = 1;
                }
            }
        }
        
        return false;
    }
}
// @lc code=end

