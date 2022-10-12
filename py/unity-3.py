#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 
# @param edges int整型一维数组 
# @return int整型
#
class Solution:
    def longestCycle(self , edges: List[int]) -> int:
        # write code here

        n = len(edges)
        visited = [False for _ in range(n)]
        l = -1

        def dfs(node, cnt, path):
            nonlocal l
            if visited[node]:
                return
            
            if node in path:
                l = max(l, cnt - path[node])
                return

            path[node] = cnt
            if edges[node] != -1:
                dfs(edges[node], cnt + 1, path)

            visited[node] = True

        for i in range(n):
            dfs(i, 0, {})

        return l

        
            