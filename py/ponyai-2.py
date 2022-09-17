n,m=list(map(int,input().split()))
board = []
for _ in range(n):
    board.append(input())

directions = {'^':(-1,0),'v':(1,0),'<':(0,-1),'>':(0,1)}

visited = set()
cache = {}
ans = 0
x = y = 0
def dfs():
    global x,y, ans, visited
    while 0<=x<n and 0<=y<m and (x,y) not in visited:
        if (x,y) in cache:
            visited = visited.union(cache[(x,y)])
            return

        visited.add((x,y))
        dx,dy = directions[board[x][y]]
        x += dx
        y += dy
    
    

ret = 0
for i in range(n):
    for j in range(m):
        visited = set()
        x = i
        y = j
        dfs()
        # print(visited, i,j)
        ret = max(ret, len(visited))
        cache[(i,j)] = visited

print(ret)