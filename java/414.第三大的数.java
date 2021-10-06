import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (36.39%)
 * Likes:    288
 * Dislikes: 0
 * Total Accepted:    78.4K
 * Total Submissions: 203.1K
 * Testcase Example:  '[3,2,1]'
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -2^31 
 * 
 * 
 * 
 * 
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * 
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        // method1: use stream
        // var sortedNums =
        // Arrays.stream(nums).boxed().distinct().sorted(Comparator.reverseOrder())
        // .collect(Collectors.toList());
        // if (sortedNums.size() < 3)
        // return sortedNums.get(sortedNums.size() - 1);

        // return sortedNums.get(2);

        // method2: simple condition statement
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        boolean change1 = false, change2 = false, change3 = false;
        for (var i : nums) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
                change3 = change2;
                change2 = change1;
                change1 = true;
            } else if (i == max1) {
                change1 = true;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
                change3 = change2;
                change2 = true;
            } else if (i == max2) {
                change2 = true;
            } else if (i > max3) {
                max3 = i;
                change3 = true;
            } else if (i == max3) {
                change3 = true;
            }
        }
        return change3 ? max3 : max1;
    }
}
// @lc code=end
