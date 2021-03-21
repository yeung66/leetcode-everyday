/*
 * @lc app=leetcode.cn id=73 lang=javascript
 *
 * [73] 矩阵置零
 *
 * https://leetcode-cn.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (56.04%)
 * Likes:    438
 * Dislikes: 0
 * Total Accepted:    91K
 * Total Submissions: 156.3K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 *
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 *
 *
 * 提示：
 *
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1
 * -2^31
 *
 *
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
  // O(m+n) 空间复杂度
  // const m = matrix.length, n = matrix[0].length
  // const rowZero = new Array(m).fill(false)
  // const colZero = new Array(n).fill(false)

  // for(let i=0;i<m;i++) {
  //     for(let j=0;j<n;j++) {
  //         if(matrix[i][j]===0) {
  //             rowZero[i] = true
  //             colZero[j] = true
  //         }
  //     }
  // }

  // rowZero.forEach((val, idx) => {
  //     if(val) {
  //         for(let j=0;j<n;j++) matrix[idx][j] = 0
  //     }
  // })

  // colZero.forEach((val, idx) => {
  //     if(val) {
  //         for(let i=0;i<m;i++) matrix[i][idx] = 0
  //     }
  // })

  // O(1) 空间复杂度
  const m = matrix.length,
    n = matrix[0].length;
  let col0Zero = false,
    row0Zero = false;

  for (let i = 0; i < m; i++) {
    if (matrix[i][0] === 0) {
      col0Zero = true;
      break;
    }
  }

  for (let i = 0; i < n; i++) {
    if (matrix[0][i] === 0) {
      row0Zero = true;
      break;
    }
  }

  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      if (matrix[i][j] === 0) {
        matrix[0][j] = 0;
        matrix[i][0] = 0;
      }
    }
  }

  for (let i = 1; i < m; i++) {
    if (matrix[i][0] === 0) {
      for (let j = 1; j < n; j++) {
        matrix[i][j] = 0;
      }
    }
  }

  for (let i = 1; i < n; i++) {
    if (matrix[0][i] === 0) {
      for (let j = 1; j < m; j++) {
        matrix[j][i] = 0;
      }
    }
  }

  if(col0Zero) {
      for(let i=0;i<m;i++) matrix[i][0] = 0
  }

  if(row0Zero) {
    for(let i=0;i<n;i++) matrix[0][i] = 0
}
};
// @lc code=end
