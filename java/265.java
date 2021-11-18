import java.util.Arrays;

class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[] prevRow = new int[0];
        int fmin = 0, smin = 0, fminIdx = -1;

        for (int i = 0; i < n; i++) {
            int[] row = new int[k];
            int curFmin = Integer.MAX_VALUE, curSmin = Integer.MAX_VALUE, curFminIdx = -1;
            for (int j = 0; j < k; j++) {
                row[j] = (fminIdx == j ? smin : fmin) + costs[i][j];

                if (row[j] < curFmin) {
                    curSmin = curFmin;
                    curFmin = row[j];
                    curFminIdx = j;
                } else if (row[j] < curSmin) {
                    curSmin = row[j];
                }
            }
            
            fmin = curFmin;
            smin = curSmin;
            fminIdx = curFminIdx;
            prevRow = row;
        }

        return Arrays.stream(prevRow).min().getAsInt();
    }
}