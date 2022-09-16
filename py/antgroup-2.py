# 几个坑点：
# 1. 会存在完成不了的情况，需要输出 -1 （想到了但没提示，就没处理
# 2. 输出的是节点的边关系，并不是父子关系
# 3. 实际给出的是一个图，而不是一个树，相当于是从 1 号节点出发遍历无向图得到一个生成树

n = int(input())


graph = [set() for _ in range(n+1)]

for _ in range(n-1):
    u, v = list(map(int, input().split()))
    graph[u].add(v)
    graph[v].add(u) 

visited = [False for _ in range(n+1)]
ret = 0

def dfs(node, add):
    global ret
    if node < add or ret == -1:
        ret = -1
        return

    ret += node - add
    visited[node] = True
    for c in graph[node]:
        if not visited[c]:
            dfs(c, node)

print(ret)