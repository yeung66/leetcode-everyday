/*
 * @lc app=leetcode.cn id=1345 lang=java
 *
 * [1345] 跳跃游戏 IV
 *
 * https://leetcode-cn.com/problems/jump-game-iv/description/
 *
 * algorithms
 * Hard (36.66%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 25.4K
 * Testcase Example:  '[100,-23,-23,404,100,23,23,23,3,404]'
 *
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * 
 * 每一步，你可以从下标 i 跳到下标：
 * 
 * 
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 
 * 
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * 
 * 注意：任何时候你都不能跳到数组外面。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 
 * 
 * 示例 2：
 * 
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 
 * 
 * 示例 3：
 * 
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 
 * 
 * 示例 4：
 * 
 * 输入：arr = [6,1,9]
 * 输出：2
 * 
 * 
 * 示例 5：
 * 
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * 
 * 
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> idxSameVal = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idxSameVal.putIfAbsent(arr[i], new ArrayList<>());
            idxSameVal.get(arr[i]).add(i);
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0 });
        visited.add(0);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int idx = cur[0], step = cur[1];
            if (idx == arr.length - 1) {
                return step;
            }

            if (idxSameVal.containsKey(arr[idx])) {
                for (var i : idxSameVal.get(arr[idx])) {
                    if (visited.add(i)) {
                        queue.offer(new int[] { i, step + 1 });
                    }
                }

                idxSameVal.remove(arr[idx]);
            }

            if (idx + 1 < arr.length && visited.add(idx + 1)) {
                queue.offer(new int[] { idx + 1, step + 1 });
            }

            if (idx - 1 >= 0 && visited.add(idx - 1)) {
                queue.offer(new int[] { idx - 1, step + 1 });
            }
        }

        return arr.length - 1;
    }   
}
// @lc code=end

