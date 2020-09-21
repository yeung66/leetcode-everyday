#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#
# https://leetcode-cn.com/problems/group-anagrams/description/
#
# algorithms
# Medium (63.60%)
# Likes:    473
# Dislikes: 0
# Total Accepted:    107.6K
# Total Submissions: 169.1K
# Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
#
# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
# 
# 示例:
# 
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
# 输出:
# [
# ⁠ ["ate","eat","tea"],
# ⁠ ["nat","tan"],
# ⁠ ["bat"]
# ]
# 
# 说明：
# 
# 
# 所有输入均为小写字母。
# 不考虑答案输出的顺序。
# 
# 
# ["ddddddddddg","dgggggggggg"]

# @lc code=start
import collections
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 计数 as key
        # ans = {}

        # def gen_tuple(word):
        #     count = collections.defaultdict(int)
        #     for i in word:
        #         count[i] += 1
        #     return tuple(sorted((k,v) for k,v in count.items()))

        # for word in strs:
        #     chars = gen_tuple(word)
        #     if chars not in ans: ans[chars] = [word]
        #     else: ans[chars].append(word)

        # return list(ans.values())

        ans = collections.defaultdict(list)

        for word in strs:
            ans[''.join(sorted(word))].append(word)

        return list(ans.values())


# @lc code=end

