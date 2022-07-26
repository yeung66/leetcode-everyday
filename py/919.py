# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class CBTInserter:

    def __init__(self, root: TreeNode):
        self.root = root
        self.queue = [root]
        self.left = True
        
        end = False
        while not end and len(self.queue)>0:
            new_queue = []
            while not end and len(self.queue)>0:
                node = self.queue.pop(0)
                if not node.left and not node.right:
                    new_queue.insert(0, node)
                if node.left:
                    new_queue.append(node.left)
                if node.right:
                    new_queue.append(node.right)

                else:
                    self.queue.insert(0, node)
                    end = True

            if end:
                new_queue = self.queue + new_queue
            self.queue = new_queue


    def insert(self, val: int) -> int:
        node = TreeNode(val)
        ret = self.queue[0].val
        print(self.queue)
        if self.queue[0].left:
            self.queue[0].right = node
            self.queue.pop(0)
        else:
            self.queue[0].left = node

        self.queue.append(node)

        return ret

    def get_root(self) -> TreeNode:
        return self.root



# Your CBTInserter object will be instantiated and called as such:
# obj = CBTInserter(root)
# param_1 = obj.insert(val)
# param_2 = obj.get_root()