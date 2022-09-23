
# If you need to import additional packages or classes, please import here.
# 从起点 2 出发到终点 3 所需要的最少时间
# 1 是墙，4 是陷阱，需要 3 个时间，6 是炸弹可以炸掉附近的墙

def func():

    # please define the python3 input here. For example: a,b = map(int, input().strip().split())
    m, n = list(map(int, input().split()))
    board = []
    start = end = None
    for i in range(m):
        board.append(list(map(int,input().split())))
        for j in range(n):
            if board[i][j] == 2:
                start = (i, j)
            elif board[i][j] == 3:
                end = (i, j)

    directions = [(1,0), (-1,0),(0,1),(0,-1)]
    ans = 25 * 25 * 3
    def dfs(point, steps):
        nonlocal ans
        # print(point, steps)

        if point == end:
            ans = min(ans, steps)
            return

        # 可以剪枝
        if steps >= ans: 
            return 

        if steps + abs(end[1]-start[1]) + abs(end[0]-start[0]) >= ans:
            return

        for dx, dy in directions:
            nx, ny = point[0] + dx, point[1] + dy

            if 0 <= nx < m and 0 <= ny < n:
                if board[nx][ny] == 0:
                    board[nx][ny] = -1
                    dfs((nx,ny), steps+1)
                    board[nx][ny] = 0
                elif board[nx][ny] == 3:
                    ans = min(ans, steps+1)
                    return
                elif board[nx][ny] == 4:
                    board[nx][ny] = -1
                    dfs((nx,ny), steps+3)
                    board[nx][ny] = 4
                elif board[nx][ny] == 6:
                    restore = []
                    for dx, dy in directions:
                        px, py = nx + dx, ny + dy
                        if 0 <= px < m and 0 <= py < n:
                            if board[px][py] == 1:
                                board[px][py] = 0
                                restore.append((px,py))
                    board[nx][ny] = -1
                    dfs((nx,ny), steps+1)
                    board[nx][ny] = 6
                    for rx, ry in restore:
                        board[rx][ry] = 1

    dfs(start, 0)
    print(ans)
        



if __name__ == "__main__":
    func()
