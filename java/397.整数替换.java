import java.util.*;

/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 *
 * https://leetcode-cn.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (37.76%)
 * Likes:    148
 * Dislikes: 0
 * Total Accepted:    27.2K
 * Total Submissions: 66.6K
 * Testcase Example:  '8'
 *
 * 给定一个正整数 n ，你可以做如下操作：
 * 
 * 
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 
 * 
 * n 变为 1 所需的最小替换次数是多少？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 4
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    // Map<Integer, Integer> memo = new HashMap<>() {
    //     {
    //         put(2147483647, 32);
    // }};

    // public int integerReplacement(int n) {
    //     if (n == 1)
    //         return 0;

    //     if (memo.containsKey(n))
    //         return memo.get(n);

    //     int ans;
    //     if (n % 2 == 0)
    //         ans = integerReplacement(n / 2) + 1;
    //     else {
    //         ans = Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;          
    //     }

    //     memo.put(n, ans);
    //     return ans;
    // }

    public int integerReplacement(int n) {
        // 贪心
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                ans++;
            } else if (n % 4 == 1) {
                ans += 2;
                n = n / 2;
            } else {
                if (n == 3) {
                    n = 1;
                    ans += 2;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }

            }
        }
        return ans;
    }    

}
// @lc code=end

