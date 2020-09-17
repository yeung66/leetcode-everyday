#
# @lc app=leetcode.cn id=438 lang=python3
#
# [438] 找到字符串中所有字母异位词
#
# https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
#
# algorithms
# Medium (45.81%)
# Likes:    367
# Dislikes: 0
# Total Accepted:    39.6K
# Total Submissions: 84.9K
# Testcase Example:  '"cbaebabacd"\n"abc"'
#
# 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
# 
# 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
# 
# 说明：
# 
# 
# 字母异位词指字母相同，但排列不同的字符串。
# 不考虑答案输出的顺序。
# 
# 
# 示例 1:
# 
# 
# 输入:
# s: "cbaebabacd" p: "abc"
# 
# 输出:
# [0, 6]
# 
# 解释:
# 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
# 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
# 
# 
# 示例 2:
# 
# 
# 输入:
# s: "abab" p: "ab"
# 
# 输出:
# [0, 1, 2]
# 
# 解释:
# 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
# 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
# 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
# 
# 
#

# @lc code=start
import collections

class Solution:
    def findAnagrams(self, s2: str, s1: str) -> List[int]:
        target = collections.defaultdict(int)
        count = collections.defaultdict(int)
        for i in s1: target[i] += 1

        def judge():
            for i in target:
                if count[i] < target[i]: return False
            return True

        left, right = 0, 0
        ans = []
        while right < len(s2):
            count[s2[right]] += 1
            right += 1

            while judge():
                if right - left == len(s1):
                    # print(f'{left} {right}')
                    # print(s2[left:right])
                    # return True
                    ans.append(left)
                    
                count[s2[left]] -= 1
                left += 1

        return ans
        
# @lc code=end

