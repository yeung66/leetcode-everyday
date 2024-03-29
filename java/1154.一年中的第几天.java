import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 *
 * https://leetcode-cn.com/problems/day-of-the-year/description/
 *
 * algorithms
 * Easy (57.21%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    25.9K
 * Total Submissions: 41.3K
 * Testcase Example:  '"2019-01-09"'
 *
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * 
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2
 * 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：date = "2019-01-09"
 * 输出：9
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：date = "2019-02-10"
 * 输出：41
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：date = "2003-03-01"
 * 输出：60
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：date = "2004-03-01"
 * 输出：61
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        days[2] = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // try {
        //     return (int) ((sdf.parse(date).getTime() - sdf.parse(date.substring(0, 4) + "-01-01").getTime()) / (1000 * 60 * 60 * 24)) + 1;
        // } catch (Exception e) {
            
        // }
        // return 0;

        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += days[i];
        }

        return ans + day;
    }
}
// @lc code=end

