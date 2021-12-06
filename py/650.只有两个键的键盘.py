#
# @lc app=leetcode.cn id=650 lang=python3
#
# [650] 只有两个键的键盘
#
# https://leetcode-cn.com/problems/2-keys-keyboard/description/
#
# algorithms
# Medium (56.75%)
# Likes:    431
# Dislikes: 0
# Total Accepted:    50.7K
# Total Submissions: 89.4K
# Testcase Example:  '3'
#
# 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
# 
# 
# Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
# Paste（粘贴）：粘贴 上一次 复制的字符。
# 
# 
# 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：3
# 输出：3
# 解释：
# 最初, 只有一个字符 'A'。
# 第 1 步, 使用 Copy All 操作。
# 第 2 步, 使用 Paste 操作来获得 'AA'。
# 第 3 步, 使用 Paste 操作来获得 'AAA'。
# 
# 
# 示例 2：
# 
# 
# 输入：n = 1
# 输出：0
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= n <= 1000
# 
# 
#

# @lc code=start
class Solution:
    cache = {1: 0}

    def minSteps(self, n: int) -> int:

        if n in Solution.cache:
            return Solution.cache[n]

        ans = n
        for i in range(2, n):
            if n % i == 0:
                ans = min(ans, self.minSteps(i) + (n // i))

        Solution.cache[n] = ans
        return ans
# @lc code=end

