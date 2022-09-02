class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        idx = 0
        for i in popped:
            while (not stack or stack[-1] != i) and idx < len(pushed):
                stack.append(pushed[idx])
                idx += 1                

            if stack.pop() != i:
                return False

        return True