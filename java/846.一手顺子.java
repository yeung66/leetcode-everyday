import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=846 lang=java
 *
 * [846] 一手顺子
 *
 * https://leetcode-cn.com/problems/hand-of-straights/description/
 *
 * algorithms
 * Medium (51.42%)
 * Likes:    188
 * Dislikes: 0
 * Total Accepted:    26.8K
 * Total Submissions: 47.5K
 * Testcase Example:  '[1,2,3,6,2,3,4,7,8]\n3'
 *
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * 
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true
 * ；否则，返回 false 。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 
 * 示例 2：
 * 
 * 
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= hand.length <= 10^4
 * 0 <= hand[i] <= 10^9
 * 1 <= groupSize <= hand.length
 * 
 * 
 * 
 * 
 * 注意：此题目与 1296
 * 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * 
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        if (groupSize == 1) {
            return true;
        }

        Arrays.sort(hand);

        boolean[] used = new boolean[n];
        int last = hand[0], cnt = 1;
        used[0] = true;
        int i = 1;

        
        while (i < n) {
            if (used[i]) {
                i++;
                continue;
            }
            if (cnt == groupSize) {
                i = 0;
                cnt = 0;
            } else {
                if (cnt == 0 || hand[i] == last + 1) {
                    used[i] = true;
                    cnt++;
                    last = hand[i];
                } else if (hand[i] != last){
                    return false;
                }
                i++;
            }
        }
        
        for (boolean b : used) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

