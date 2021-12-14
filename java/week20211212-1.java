class Solution {
    public int countPoints(String rings) {
        int[][] count = new int[10][3];

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int idx = rings.charAt(i + 1) - '0';
            if (color == 'R') {
                count[idx][0] = 1;
            } else if (color == 'G') {
                count[idx][1] = 1;
            } else {
                count[idx][2] = 1;
            }
        }

        int ans = 0;
        for (int[] flag : count) {
            boolean can = true;
            for (int c : flag) {
                if (c == 0) can = false;
            }

            if (can) ans++;
        }

        return ans;
    }
}