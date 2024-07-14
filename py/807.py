class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int: 
        n = len(grid)
        rowsMax = [max(r) for r in grid]
        colsMax = [max(r[c] for r in grid) for c in range(n)]

        ans = 0
        for i in range(n):
            for j in range(n):
                ans += min(rowsMax[i], colsMax[j]) - grid[i][j]

        return ans
        