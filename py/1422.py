class Solution:
    def maxScore(self, s: str) -> int:
        ones = s.count('1')
        cur = ans = 0
        
        for c in s[:-1]:
            if c == '0':
                cur += 1
            else:
                ones -= 1

            ans = max(ans, cur + ones)

        return ans