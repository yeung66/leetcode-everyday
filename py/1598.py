class Solution:
    def minOperations(self, logs: List[str]) -> int:
        dirs = 0
        for i in logs:
            if i == '../':
                dirs -= 1 if dirs > 0 else 0
            elif i == './':
                continue
            else:
                dirs += 1

        return dirs