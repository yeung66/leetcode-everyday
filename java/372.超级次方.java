/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 *
 * https://leetcode-cn.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (50.98%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    20.9K
 * Total Submissions: 38.8K
 * Testcase Example:  '2\n[3]'
 *
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：a = 2, b = [3]
 * 输出：8
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 0 
 * b 不含前导 0
 * 
 * 
 */

// @lc code=start
class Solution {
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    final int MOD = 1337; 

    public int dfs(int a, int[]b, int u) {
        if (u == -1)
            return 1;

        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
    }

    public int pow(int a, int b) {

        int ans = 1;
        a %= MOD;

        while (b > 0) {
            ans = ans * a % MOD;
            b--;
        }

        return ans;
    }

    public int qpow(int a, int b) {
        int ans = 1;
        a = a % MOD;

        while (b > 0) {
            if (b & 1 != 0)
                ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }

        return ans;
    }
}
// @lc code=end

