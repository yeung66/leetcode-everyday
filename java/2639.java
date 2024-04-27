import java.util.ArrayList;
import java.util.List;

class Solution {

    private int len(int num) {
        return String.valueOf(num).length();
    }
    public int[] findColumnWidth(int[][] grid) {
        int[] widths = new int[grid[0].length];

        for (int i = 0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (len(grid[i][j]) > widths[j]) widths[j] = len(grid[i][j]);
            }
        }

        return widths;
    }
}