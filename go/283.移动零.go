/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (63.72%)
 * Likes:    1027
 * Dislikes: 0
 * Total Accepted:    353.4K
 * Total Submissions: 554.5K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */
package main
// @lc code=start
func moveZeroes(nums []int)  {
	offset:=0
	for i:=0;i<len(nums);i++ {
		if(nums[i]!=0) {
			nums[i-offset] = nums[i]
		} else {
			offset++
		}

	}

	for ;offset>0;offset-- {
		nums[len(nums)-offset] = 0
	}
}
// @lc code=end

