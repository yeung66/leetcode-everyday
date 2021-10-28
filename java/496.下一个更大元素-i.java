import java.util.*;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 *
 * https://leetcode-cn.com/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (68.73%)
 * Likes:    547
 * Dislikes: 0
 * Total Accepted:    116.3K
 * Total Submissions: 167.2K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * 
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * ⁠   对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * ⁠   对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * ⁠   对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * ⁠   对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * 
 * 
 * 
 * 
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 * 
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // for (var i = 0; i < nums1.length; i++) {
        //     var start = 0;
        //     for (; start < nums2.length && nums2[start] != nums1[i]; start++)
        //         ;
            
        //     if (start < nums2.length) {
        //         start++;
        //         while (start < nums2.length && nums2[start] < nums1[i])
        //             start++;
        //     }
            
        //     nums1[i] = start < nums2.length ? nums2[start] : -1;
            
        // }

        // return nums1;

        Map<Integer, Integer> ans = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (var i = nums2.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i])
                stack.pop();

            ans.put(nums2[i], stack.empty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        return Arrays.stream(nums1).map(x -> ans.get(x)).toArray();
    }
}
// @lc code=end

