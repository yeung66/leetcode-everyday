import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 *
 * https://leetcode-cn.com/problems/count-good-meals/description/
 *
 * algorithms
 * Medium (25.55%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 46.7K
 * Testcase Example:  '[1,3,5,7,9]'
 *
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i^​​​​​​​​​​​​​​
 * 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * 
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */
import java.util.Map;


// @lc code=start
class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (var i : deliciousness) {
            maxVal = Math.max(i, maxVal);
        }
        maxVal *= 2;

        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (var i : deliciousness) {
            for (int sum = 1; sum <= maxVal; sum <<= 1) {
                if (count.containsKey(sum - i)) {
                    ans = (ans + count.get(sum - i)) % MOD;
                }
            }
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        return ans;
    }
}
// @lc code=end

