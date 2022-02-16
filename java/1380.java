class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for (var row : matrix) {
            int min = row[0], minidx = 0;
            for (int j = 1; j < row.length; j++) {
                if (row[j] < min) {
                    min = row[j];
                    minidx = j;
                }
            }

            boolean isLucky = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][minidx] > min) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                ans.add(min);
            }

        }

        return ans;
    }
}