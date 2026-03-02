class Solution:
    def binaryGap(self, n: int) -> int:
        digits = bin(n)[2:]
        start, cnt = False, 0
        ans = 0
        for i in digits:
            if i == '1':
                if not start:
                    start = True
                else:
                    ans = max(ans, cnt + 1)
                    cnt = 0

                start = True
            else:
                cnt += 1

        return ans
