#
# @lc app=leetcode.cn id=1034 lang=python3
#
# [1034] 边界着色
#
# https://leetcode-cn.com/problems/coloring-a-border/description/
#
# algorithms
# Medium (44.27%)
# Likes:    80
# Dislikes: 0
# Total Accepted:    11.5K
# Total Submissions: 22.2K
# Testcase Example:  '[[1,1],[1,2]]\n0\n0\n3'
#
# 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color
# 。网格中的每个值表示该位置处的网格块的颜色。
# 
# 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
# 
# 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
# 
# 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
# 输出：[[3,3],[3,2]]
# 
# 示例 2：
# 
# 
# 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
# 输出：[[1,3,3],[2,3,3]]
# 
# 示例 3：
# 
# 
# 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
# 输出：[[2,2,2],[2,1,2],[2,2,2]]
# 
# 
# 
# 提示：
# 
# 
# m == grid.length
# n == grid[i].length
# 1 <= m, n <= 50
# 1 <= grid[i][j], color <= 1000
# 0 <= row < m
# 0 <= col < n
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    def colorBorder(self, grid: List[List[int]], row: int, col: int, color: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])

        queue = [(row, col)]
        dir = ((-1,0),(1,0),(0,-1),(0,1))
        prevColor = grid[row][col]

        nonBorders = []
        borders = []

        while len(queue) != 0:
            x,y = queue.pop(0)
            grid[x][y] =  0
            isBorder =  False
            for dx, dy in dir:
                nx, ny = x + dx, y + dy
                if 0<=nx<m and 0<=ny<n and grid[nx][ny] == prevColor:
                    queue.append((nx,ny))
                elif not (0 <= nx < m and 0 <= ny < n) or grid[nx][ny] != 0:
                    isBorder = True

            if not isBorder:
                nonBorders.append((x,y))
            else:
                borders.append((x,y))

        for x,y in nonBorders:
            grid[x][y] = prevColor

        for x,y in borders:
            grid[x][y] = color


        return grid

        

# @lc code=end

