n, m, x, y = list(map(int, input().split()))

blocked = set()
steps = [(-1,-2),(-2,-1),(-2,1),(-1,2),(0,0),(1,2),(2,1),(2,-1),(1,-2)]
for dx,dy in steps:
    nx, ny = x+dx,y+dy
    blocked.add((nx, ny))

cnt = 0
cache = {}

def dfs(x, y):
    global cnt
    if (x,y) in cache:
        return cache[(x,y)]

    if x == n and y == m:
        cnt += 1
        return 1

    ans = 0
    if y+1<=m and (x,y+1) not in blocked:
        ans += dfs(x,y+1)
    if x+1<=n and (x+1,y) not in blocked:
        ans += dfs(x+1,y)

    cache[(x,y)] = ans
    return ans


print(dfs(0,0))