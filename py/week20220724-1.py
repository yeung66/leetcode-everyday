class Solution:
    def repeatedCharacter(self, s: str) -> str:
        cnt = set()
        for i in s:
            if i not in cnt:
                cnt.add(i)
            else:
                return i