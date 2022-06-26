class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        l1, l2 = len(s), len(t)
        if abs(l1 - l2) > 1:
            return False

        if l1 == l2:
            diff = 0
            for i in range(l1):
                if s[i] != t[i]:
                    diff += 1

            return diff == 1

        elif l1 + 1 == l2:
            for i in range(l2):
                if s[:i] + t[i] + s[i:] == t:
                    return True

        else:
            for i in range(l1):
                if t[:i] + s[i] + t[i:] == s:
                    return True

        return False
