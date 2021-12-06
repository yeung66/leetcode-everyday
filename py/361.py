class Solution:
    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        dp1 = [[0 for _ in range(n)] for _ in range(m)]

        colCount = [0 for _ in range(n)]
        ans = 0
        for i in range(m):
            rowCount = 0
            for j in range(n):
                if grid[i][j] == 'W':
                    rowCount = 0
                    colCount[j] = 0
                    continue

                dp1[i][j] = rowCount + colCount[j]

                if grid[i][j] == 'E':
                    rowCount += 1
                    colCount[j] += 1
                    dp1[i][j] = 0

                


        colCount = [0 for _ in range(n)]
        for i in range(m-1, -1, -1):
            rowCount = 0
            for j in range(n-1, -1, -1):
                if grid[i][j] == 'W':
                    rowCount = 0
                    colCount[j] = 0
                    continue

                dp1[i][j] += rowCount + colCount[j]
                if grid[i][j] == 'E':
                    rowCount += 1
                    colCount[j] += 1
                    dp1[i][j] = 0

                ans = max(dp1[i][j], ans)
        return ans
