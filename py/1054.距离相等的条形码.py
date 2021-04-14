#
# @lc app=leetcode.cn id=1054 lang=python3
#
# [1054] 距离相等的条形码
#
# https://leetcode-cn.com/problems/distant-barcodes/description/
#
# algorithms
# Medium (36.72%)
# Likes:    62
# Dislikes: 0
# Total Accepted:    6.8K
# Total Submissions: 18.4K
# Testcase Example:  '[1,1,1,2,2,2]'
#
# 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
# 
# 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
# 
# 
# 
# 示例 1：
# 
# 输入：[1,1,1,2,2,2]
# 输出：[2,1,2,1,2,1]
# 
# 
# 示例 2：
# 
# 输入：[1,1,1,1,2,2,3,3]
# 输出：[1,3,1,3,2,1,2,1]
# 
# 
# 
# 提示：
# 
# 
# 1 <= barcodes.length <= 10000
# 1 <= barcodes[i] <= 10000
# 
# 
# 
# 
#

# @lc code=start
from queue import PriorityQueue
class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        count = {}
        for i in barcodes:
            if i not in count: count[i] = 1
            else: count[i]+=1
        
        ans = []
        queue = PriorityQueue()
        for k,v in count.items(): queue.put((-1*v, k))

        while not queue.empty():
            i1_count, i1_val = queue.get()
            if queue.empty(): 
                ans.append(i1_val)
                break
            i2_count, i2_val = queue.get()
            ans.extend((i1_val,i2_val))
            if i1_count!=-1: queue.put((i1_count+1, i1_val))
            if i2_count!=-1: queue.put((i2_count+1, i2_val))

        return ans



# @lc code=end

