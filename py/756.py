import collections

class Solution:
    def pyramidTransition(self, bottom: str, allowed: list[str]) -> bool:
        # 1. 预处理 allowed 列表，转为字典方便查找
        # 格式: map['AB'] = ['C', 'D', ...]
        patterns = collections.defaultdict(list)
        for p in allowed:
            patterns[p[:2]].append(p[2])
        
        # 记忆化，存储无法成功的 bottom 状态
        memo = set()

        def dfs(current_row):
            # Base Case: 如果当前层只剩1个砖块，说明成功到达塔顶
            if len(current_row) == 1:
                return True
            
            # 如果这个状态之前已经验证过是死路，直接返回 False
            if current_row in memo:
                return False
            
            # 尝试构建下一层，如果成功构建且能通往塔顶，返回 True
            if build_next_row(current_row, 0, []):
                return True
            
            # 如果所有尝试都失败，记录该状态为死路
            memo.add(current_row)
            return False

        # 辅助函数：构建下一层
        # index: 当前正在处理 current_row 的第几个位置
        # path: 正在构建的下一层积木列表
        def build_next_row(row, index, path):
            # Base Case: 下一层的长度应该是当前层长度 - 1
            if len(path) == len(row) - 1:
                # 下一层构建完毕，递归调用主 dfs 进入更上一层
                return dfs("".join(path))
            
            # 获取当前底座的两个砖块
            base = row[index:index+2]
            
            # 如果这个底座组合在 allowed 里有对应的顶块
            if base in patterns:
                for top in patterns[base]:
                    path.append(top) # 做选择
                    if build_next_row(row, index + 1, path): # 递归
                        return True
                    path.pop() # 撤销选择 (回溯)
            
            return False

        return dfs(bottom)

