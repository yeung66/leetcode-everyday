import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 *
 * https://leetcode-cn.com/problems/heaters/description/
 *
 * algorithms
 * Medium (33.85%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    27.7K
 * Total Submissions: 77.4K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int l = 1, h = (int) 1e9 + 1;
        while (l != h) {
            int r = (h - l) / 2 + l;
            if (check(houses, heaters, r)) {
                h = r;
            } else {
                l = r + 1;
            }
        }

        return l;
    }

    public boolean check(int[] houses, int[] heaters, int r) {
        int i = 0, j = 0;
        while (i < houses.length && j < heaters.length) {
            int house = houses[i], heater = heaters[j];
            if (house >= heater - r && house <= heater + r) {
                i++;
            } else if (house > heater + r) {
                j++;
            } else {
                return false;
            }
        }
        
        return i == houses.length;
    }
}
// @lc code=end

