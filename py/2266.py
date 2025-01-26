class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        n = len(pressedKeys)
        MOD = 10**9 + 7
        dp = [0] * (n + 1)
        dp[0] = 1  # 初始条件

        # 每个数字对应的最大连续按键次数
        max_presses = {
            '2': 3, '3': 3, '4': 3, '5': 3, '6': 3, '8': 3,
            '7': 4, '9': 4
        }

        for i in range(1, n + 1):
            dp[i] = dp[i - 1]  # 至少可以由前一个状态转移过来
            max_press = max_presses[pressedKeys[i - 1]]

            # 向前查看最多 max_press 个字符
            for j in range(2, max_press + 1):
                if i - j < 0 or pressedKeys[i - j] != pressedKeys[i - 1]:
                    break
                dp[i] += dp[i - j]
                dp[i] %= MOD

        return dp[n]

        return ans