from typing import Optional


class TreeNode:
    def __init__(self, val) -> None:
        self.val = val
        self.left = self.right = None

def infix_order(root: Optional[TreeNode]):
    if not root:
        return

    stack = []
    output = []
    node = root
    while node:
        while node.left:
            stack.append(node)
            node = node.left

        output.append(node.val)
        if node.right:
            node = node.right
        else:
            while not node.right and stack:
                node = stack.pop()
                output.append(node.val)
                
            node = node.right

    print(' '.join(map(str, output)))

if __name__ == '__main__':
    root = TreeNode(0)
    root.left = TreeNode(12)
    root.right = TreeNode(3)
    root.left.right =  TreeNode(4)
    infix_order(root)


