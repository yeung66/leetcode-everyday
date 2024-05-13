class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False for j in range(n)] for i in range(m)]
        q = []

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2 and not visited[i][j]:
                    visited[i][j] = True
                    q.append((i,j))
        
        cnt = -1
        while len(q) > 0:
            new_q = []
            while len(q) > 0:
                x, y = q.pop(0)
                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                        nx, ny = dx + x, dy + y
                        if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == 1:
                            visited[nx][ny] = True
                            grid[nx][ny] = 2
                            new_q.append((nx, ny))

            q = new_q
            cnt += 1
        

        return -1 if any(any(i == 1 for i in row) for row in grid) else max(0, cnt)