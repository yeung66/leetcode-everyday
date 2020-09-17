#
# @lc app=leetcode.cn id=76 lang=python3
#
# [76] 最小覆盖子串
#
# https://leetcode-cn.com/problems/minimum-window-substring/description/
#
# algorithms
# Hard (38.62%)
# Likes:    752
# Dislikes: 0
# Total Accepted:    79.2K
# Total Submissions: 202.4K
# Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
#
# 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
# 
# 
# 
# 示例：
# 
# 输入：S = "ADOBECODEBANC", T = "ABC"
# 输出："BANC"
# 
# 
# 
# 提示：
# 
# 
# 如果 S 中不存这样的子串，则返回空字符串 ""。
# 如果 S 中存在这样的子串，我们保证它是唯一的答案。
# 
# 
#

# @lc code=start
import collections


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        tar = collections.defaultdict(int)
        for i in t: tar[i] += 1
        cnt = collections.defaultdict(int)

        def containsAll():
            for c in tar:
                if cnt[c] < tar[c]: return False
            return True

        left, right = 0, 0
        ansLeft, ansRight, ansLength = 0, 0, float('inf')
        while right < len(s):
            cnt[s[right]] += 1
            right += 1

            while containsAll():
                if right - left < ansLength:
                    ansLeft, ansRight, ansLength = left, right, right - left
                cnt[s[left]] -= 1
                left += 1

        return s[ansLeft:ansRight] if ansLength < float('inf') else ''



# @lc code=end

