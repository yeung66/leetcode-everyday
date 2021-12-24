#
# @lc app=leetcode.cn id=686 lang=python3
#
# [686] 重复叠加字符串匹配
#
# https://leetcode-cn.com/problems/repeated-string-match/description/
#
# algorithms
# Medium (35.74%)
# Likes:    188
# Dislikes: 0
# Total Accepted:    24.4K
# Total Submissions: 64.8K
# Testcase Example:  '"abcd"\n"cdabcdab"'
#
# 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
# 
# 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
# 
# 
# 
# 示例 1：
# 
# 输入：a = "abcd", b = "cdabcdab"
# 输出：3
# 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
# 
# 
# 示例 2：
# 
# 输入：a = "a", b = "aa"
# 输出：2
# 
# 
# 示例 3：
# 
# 输入：a = "a", b = "a"
# 输出：1
# 
# 
# 示例 4：
# 
# 输入：a = "abc", b = "wxyz"
# 输出：-1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= a.length <= 10^4
# 1 <= b.length <= 10^4
# a 和 b 由小写英文字母组成
# 
# 
#

# @lc code=start
class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        low, high = 1, len(b) // len(a) + 1
        while low != high:
            mid = (low + high) // 2
            if b in a * mid:
                high = mid
            else:
                low = mid + 1

        return high if b in high * a else -1
# @lc code=end

