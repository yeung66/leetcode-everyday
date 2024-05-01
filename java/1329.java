class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = 0;i<mat[0].length;i++) {
            sortOneDiagonal(mat, 0, i);
        }
        
        for (int i = 1;i<mat.length;i++){
            sortOneDiagonal(mat, i, 0);
        }
        
        return mat;
    }

    void sortOneDiagonal(int[][] mat, int startX, int startY) {
        int length = Math.min(mat[0].length - startY, mat.length - startX);
        for (int i = 0;i < length;i++) {
            for (int j=0;j<length-i-1;j++) {
                if (mat[startX+j][startY+j] > mat[startX+j+1][startY+j+1]) {
                    int temp = mat[startX+j][startY+j];
                    mat[startX+j][startY+j] = mat[startX+j+1][startY+j+1];
                    mat[startX+j+1][startY+j+1] = temp;
                }
            }
        }
    }
}