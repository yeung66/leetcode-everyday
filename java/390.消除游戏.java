/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 *
 * https://leetcode-cn.com/problems/elimination-game/description/
 *
 * algorithms
 * Medium (46.69%)
 * Likes:    254
 * Dislikes: 0
 * Total Accepted:    27.9K
 * Total Submissions: 45.9K
 * Testcase Example:  '9'
 *
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * 
 * 
 * 
 * 
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 
 * 
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^9
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        int start = 1, end = n;
        int cnt = n, step = 1;
        int k = 0;
        while (start < end) {
            if (k % 2 == 0) {
                start = start + step;
                if (cnt % 2 == 1) {
                    end = end - step;
                }
            } else {
                end = end - step;
                if (cnt % 2 == 1) {
                    start += step;
                }
            }

            step *= 2;
            cnt = (end - start) / step + 1;
            k++;
        }

        return start;
    }
}
// @lc code=end

