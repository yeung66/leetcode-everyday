// https://leetcode-cn.com/problems/check-if-every-row-and-column-contains-all-numbers/
import java.util.*;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<Integer> cnt = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cnt = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (cnt.contains(matrix[i][j])) {
                    return false;
                } else {
                    cnt.add(matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            cnt = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (cnt.contains(matrix[j][i])) {
                    return false;
                } else {
                    cnt.add(matrix[j][i]);
                }
            }
        }

        return true;
        
    }
}