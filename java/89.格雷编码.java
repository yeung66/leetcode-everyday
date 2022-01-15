import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 *
 * https://leetcode-cn.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (70.96%)
 * Likes:    416
 * Dislikes: 0
 * Total Accepted:    72.1K
 * Total Submissions: 99.4K
 * Testcase Example:  '2'
 *
 * n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
 * 
 * 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 
 * 
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 2
 * 输出：[0,1,3,2]
 * 解释：
 * [0,1,3,2] 的二进制表示是 [00,01,11,10] 。
 * - 00 和 01 有一位不同
 * - 01 和 11 有一位不同
 * - 11 和 10 有一位不同
 * - 10 和 00 有一位不同
 * [0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
 * - 00 和 10 有一位不同
 * - 10 和 11 有一位不同
 * - 11 和 01 有一位不同
 * - 01 和 00 有一位不同
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 16
 * 
 * 
 */

// @lc code=start
class Solution {
    List<Integer> seqs;
    List<Integer> ans;
    boolean[] used;
    boolean finished;
    int N;

    public List<Integer> grayCode(int n) {
        seqs = new ArrayList<>();
        ans = new ArrayList<>();
        N = (int) Math.pow(2, n);
        used = new boolean[N];
        finished = false;

        seqs.add(0);
        used[0] = true;
        dfs(0, 1);
        return ans;
    }
    
    public void dfs(int cur, int idx) {
        if (finished)
            return;

        if (idx == N) {
            var nums = nextNum(cur);
            for (var i : nums) {
                if (i == seqs.get(0)) {
                    finished = true;
                    ans.addAll(seqs);
                    return;
                }
            }
        }
        
        for (var i : nextNum(cur)) {
            if (!used[i]) {
                used[i] = true;
                seqs.add(i);
                dfs(i, idx + 1);
                if (finished)
                    return;
                seqs.remove(seqs.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<Integer> nextNum(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(1);
            return ans;
        }
        for (int i = 1; i <= n; i *= 2) {
            ans.add(i ^ n);
        }

        return ans;
    }
}
// @lc code=end

