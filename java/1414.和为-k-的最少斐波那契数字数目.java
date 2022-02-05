import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1414 lang=java
 *
 * [1414] 和为 K 的最少斐波那契数字数目
 *
 * https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/description/
 *
 * algorithms
 * Medium (60.27%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 18.5K
 * Testcase Example:  '7'
 *
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * 
 * 斐波那契数字定义为：
 * 
 * 
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 
 * 
 * 数据保证对于给定的 k ，一定能找到可行解。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：k = 7
 * 输出：2 
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * 
 * 示例 2：
 * 
 * 输入：k = 10
 * 输出：2 
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * 
 * 
 * 示例 3：
 * 
 * 输入：k = 19
 * 输出：3 
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= k <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMinFibonacciNumbers(int k) {
        var nums = fetchFib(k);
        int ans = 0;
        while (k > 0) {
            int i = search(nums, k);
            ans++;
            k -= i;
        }

        return ans;
    }

    public List<Integer> fetchFib(int k) {
        List<Integer> ans = new ArrayList<>();
        int i = 1, j = 1;
        ans.add(i);
        ans.add(j);
        while (j < k) {
            int z = i + j;
            i = j;
            j = z;
            ans.add(z);
        }

        return ans;
    }

    public int search(List<Integer> nums, int k) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums.get(mid) <= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return nums.get(l);
    }
}
// @lc code=end

