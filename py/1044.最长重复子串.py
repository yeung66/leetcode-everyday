#
# @lc app=leetcode.cn id=1044 lang=python3
#
# [1044] 最长重复子串
#
# https://leetcode-cn.com/problems/longest-duplicate-substring/description/
#
# algorithms
# Hard (20.91%)
# Likes:    202
# Dislikes: 0
# Total Accepted:    9.7K
# Total Submissions: 36.4K
# Testcase Example:  '"banana"'
#
# 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
# 
# 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "banana"
# 输出："ana"
# 
# 
# 示例 2：
# 
# 
# 输入：s = "abcd"
# 输出：""
# 
# 
# 
# 
# 提示：
# 
# 
# 2 <= s.length <= 3 * 10^4
# s 由小写英文字母组成
# 
# 
#

# @lc code=start

class Solution:
    def longestDupSubstring(self, s: str) -> str:
        # 生成两个进制
        a1, a2 = random.randint(26, 100), random.randint(26, 100)
        # 生成两个模
        mod1, mod2 = random.randint(
            10**9+7, 2**31-1), random.randint(10**9+7, 2**31-1)
        n = len(s)
        # 先对所有字符进行编码
        arr = [ord(c)-ord('a') for c in s]
        # 二分查找的范围是[1, n-1]
        l, r = 1, n-1
        length, start = 0, -1
        while l <= r:
            m = l + (r - l + 1) // 2
            idx = self.check(arr, m, a1, a2, mod1, mod2)
            # 有重复子串，移动左边界
            if idx != -1:
                l = m + 1
                length = m
                start = idx
            # 无重复子串，移动右边界
            else:
                r = m - 1
        return s[start:start+length] if start != -1 else ""

    def check(self, arr, m, a1, a2, mod1, mod2):
        n = len(arr)
        aL1, aL2 = pow(a1, m, mod1), pow(a2, m, mod2)
        h1, h2 = 0, 0
        for i in range(m):
            h1 = (h1 * a1 + arr[i]) % mod1
            h2 = (h2 * a2 + arr[i]) % mod2
        # 存储一个编码组合是否出现过
        seen = {(h1, h2)}
        for start in range(1, n - m + 1):
            h1 = (h1 * a1 - arr[start - 1] * aL1 + arr[start + m - 1]) % mod1
            h2 = (h2 * a2 - arr[start - 1] * aL2 + arr[start + m - 1]) % mod2
            # 如果重复，则返回重复串的起点
            if (h1, h2) in seen:
                return start
            seen.add((h1, h2))
        # 没有重复，则返回-1
        return -1
    


                

# @lc code=end

