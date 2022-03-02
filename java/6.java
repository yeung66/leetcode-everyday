import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        int col = 0, dir = 1;
        List<List<Character>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }

        for (char c : s.toCharArray()) {
            ans.get(col).add(c);

            col += dir;
            if (col == -1) {
                col = numRows == 1 ? 0 : 1;
                dir = 1;
            } else if (col == numRows) {
                col = numRows == 1 ? 0 : numRows - 2;
                dir = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (var row : ans) {
            for (var c : row) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}