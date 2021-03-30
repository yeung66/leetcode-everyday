/*
 * @lc app=leetcode.cn id=74 lang=javascript
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (38.53%)
 * Likes:    219
 * Dislikes: 0
 * Total Accepted:    55.9K
 * Total Submissions: 144.8K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    const m = matrix.length, n = matrix[0].length
    // let row;
    // for(row=0;row<m;row++) {
    //     if(matrix[row][n-1]>=target) break
    // }

    // if(row===m) return false
    // for(let col=0;col<n;col++) {
    //     if(matrix[row][col]===target) return true
    //     else if(matrix[row][col]>target) return false
    // }

    // return false
    let left = 0, right = m * n, mid, x, y

    while(left<right) {
        mid = Math.floor((left+right)/2)
        x = Math.floor(mid / n)
        y = mid % n 
        if(matrix[x][y]===target) return true
        else if(matrix[x][y]<target) left = mid + 1
        else right = mid
    }

    return false

};
// @lc code=end

