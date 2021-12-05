# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        startNode = None
        cnt = 0


        def dfs(node, p):
            nonlocal startNode, cnt
            if node:
                node.parent = p
                cnt+=1
                dfs(node.left, node)
                dfs(node.right, node)
                if node.val == startValue:
                    startNode = node

        dfs(root, None)

        visited = [False for _ in range(cnt + 1)]
        ans = None

        def dfsPath(node, prev:str):
            nonlocal ans
            if node.val == destValue:
                ans = prev
                return 

            if ans is not None:
                return

            visited[node.val] = True

            if node.left and not visited[node.left.val]:
                dfsPath(node.left, prev + 'L')

            if node.right and not visited[node.right.val]:
                dfsPath(node.right, prev + 'R')

            if node.parent and not visited[node.parent.val]:
                dfsPath(node.parent, prev + 'U')

        dfsPath(startNode, '')

        return ans


