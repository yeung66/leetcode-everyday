import java.util.*;

/*
 * @lc app=leetcode.cn id=786 lang=java
 *
 * [786] 第 K 个最小的素数分数
 *
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/description/
 *
 * algorithms
 * Hard (46.89%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    12.8K
 * Total Submissions: 20.4K
 * Testcase Example:  '[1,2,3,5]\n3'
 *
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * 
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * 
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] ==
 * arr[j] 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示: 
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 
 * 1 
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        // int[][] list = new int[n * (n - 1) / 2][2];

        // int idx = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i + 1; j < arr.length; j++) {
        //         list[idx][0] = arr[i];
        //         list[idx][1] = arr[j];
        //         idx++;
        //     }
        // }

        // Arrays.sort(list, (c1, c2) -> c1[0] * c2[1] - c2[0] * c1[1]);

        // return list[k-1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> arr[c1[0]] * arr[c2[1]] - arr[c2[0]] * arr[c1[1]]);

        for (int j = 1; j < n; j++) {
            pq.add(new int[] { 0, j });
        }

        int[] next = new int[2];

        for (int i = 0; i < k; i++) {
            next = pq.poll();
            if (arr[next[0] + 1] < arr[next[1]]) {
                pq.add(new int[] { next[0] + 1, next[1] });
            }
        }

        return new int[] { arr[next[0]], arr[next[1]] };
    }
}
// @lc code=end

