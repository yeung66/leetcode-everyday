import java.awt.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 *
 * https://leetcode-cn.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (59.64%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    29.8K
 * Total Submissions: 45.7K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 
 * timePoints[i] 格式为 "HH:MM"
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (String t : timePoints) {
            String[] parts = t.split(":");
            int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            queue.offer(minutes);
        }

        int prev = queue.poll();
        int start = prev, ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans = Math.min(ans, cur - prev);
            prev = cur;
        }

        return Math.min(ans, 24 * 60 - prev + start);
    }
}
// @lc code=end

