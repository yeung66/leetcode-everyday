import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 *
 * https://leetcode-cn.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (57.71%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    71.5K
 * Total Submissions: 119.5K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 
 * 实现 Solution class:
 * 
 * 
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * 
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回
 * [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^6 
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 10^4 次 reset 和 shuffle
 * 
 * 
 */

// @lc code=start
class Solution {

    int[] nums;
    int[] orin;
    public Solution(int[] nums) {
        orin = nums;
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
    }
    
    public int[] reset() {
        return orin;
    }
    
    public int[] shuffle() {
        
        int n = nums.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = i + random.nextInt(n - i);
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

