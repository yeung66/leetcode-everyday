#
# @lc app=leetcode.cn id=567 lang=python3
#
# [567] 字符串的排列
#
# https://leetcode-cn.com/problems/permutation-in-string/description/
#
# algorithms
# Medium (36.94%)
# Likes:    174
# Dislikes: 0
# Total Accepted:    42.5K
# Total Submissions: 113.8K
# Testcase Example:  '"ab"\n"eidbaooo"'
#
# 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
# 
# 换句话说，第一个字符串的排列之一是第二个字符串的子串。
# 
# 示例1:
# 
# 
# 输入: s1 = "ab" s2 = "eidbaooo"
# 输出: True
# 解释: s2 包含 s1 的排列之一 ("ba").
# 
# 
# 
# 
# 示例2:
# 
# 
# 输入: s1= "ab" s2 = "eidboaoo"
# 输出: False
# 
# 
# 
# 
# 注意：
# 
# 
# 输入的字符串只包含小写字母
# 两个字符串的长度都在 [1, 10,000] 之间
# 
# 
#
import collections
# @lc code=start
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        target = collections.defaultdict(int)
        count = collections.defaultdict(int)
        for i in s1: target[i] += 1

        def judge():
            for i in target:
                if count[i] < target[i]: return False
            return True

        left, right = 0, 0
        while right < len(s2):
            count[s2[right]] += 1
            right += 1

            while judge():
                if right - left == len(s1):
                    # print(f'{left} {right}')
                    # print(s2[left:right])
                    return True
                count[s2[left]] -= 1
                left += 1

        return False
# @lc code=end

