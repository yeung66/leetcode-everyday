/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 *
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/description/
 *
 * algorithms
 * Medium (54.68%)
 * Likes:    316
 * Dislikes: 0
 * Total Accepted:    57.8K
 * Total Submissions: 105.7K
 * Testcase Example:  '1'
 *
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * 
 * 不要使用系统的 Math.random() 方法。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: 1
 * 输出: [7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 2
 * 输出: [8,4]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: 3
 * 输出: [8,1,10]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 * 
 * 
 * 
 * 
 * 进阶:
 * 
 * 
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 * 
 * 
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase. public int
 * rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int row, col;
        int idx = 0;
        do {
        row = rand7();
        col = rand7();
        idx = (row-1) * 7 + col;
        } while(idx>40);
        return idx % 10 + 1;
    }
}
// @lc code=end
