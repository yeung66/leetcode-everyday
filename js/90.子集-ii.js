/*
 * @lc app=leetcode.cn id=90 lang=javascript
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (61.89%)
 * Likes:    466
 * Dislikes: 0
 * Total Accepted:    81.5K
 * Total Submissions: 130K
 * Testcase Example:  '[1,2,2]'
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    nums = nums.sort((a,b)=>a-b)
    let t = [], ans = []

    const dfs = (choosePrev, cur) => {
        if(cur===nums.length) {
            ans.push(t.slice())
            return 
        }

        dfs(false, cur+1)
        if(!choosePrev&&cur>0&&nums[cur]===nums[cur-1]) return
        
        t.push(nums[cur])
        dfs(true, cur+1)
        t = t.slice(0, t.length-1)
    }

    dfs(false, 0)
    return ans

};
// @lc code=end

