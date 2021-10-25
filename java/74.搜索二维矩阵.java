/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (46.00%)
 * Likes:    525
 * Dislikes: 0
 * Total Accepted:    175.4K
 * Total Submissions: 379.2K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * -10^4 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {        
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col;
        int left = 0, right = m; 
        while (left < right) {
            row = (left + right) / 2;
            if (target <= matrix[row][n - 1] && target >= matrix[row][0])
                break;
            if (target > matrix[row][n - 1])
                left = row + 1;
            else
                right = row;
        }

        if (left == right)
            return false;

        left = 0; right = n;
        while (left < right) {
            col = (left + right) / 2;
            if (target == matrix[row][col])
                return true;
            if (target < matrix[row][col])
                right = col;
            else
                left = col + 1;
        }

        return false;
    }
}
// @lc code=end

