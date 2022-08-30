class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] < target) {
                row += 1;
            } else if (matrix[row][col] == target) {
                break;
            } else {
                col -= 1;
            }
        }

        if (row < m && col >= 0) return matrix[row][col] == target;
        return false;
    }
}