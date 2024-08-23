class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        int[] charMinEdge = new int[26];
        Arrays.fill(charMinEdge, 1000000001);
        int edge = 1000000001;
        for (int i=0;i<n;i++) {
            int x = points[i][0], y = points[i][1], j = s.charAt(i) - 'a';
            int d = Math.max(Math.abs(x), Math.abs(y));
            if (d < charMinEdge[j]) {
                edge = Math.min(edge, charMinEdge[j]);
                charMinEdge[j] = d;
            } else if (d < edge) {
                edge = d;
            }
        }

        int res = 0;
        for (int d: charMinEdge) {
            if (d < edge) res++;
        }

        return res;
    }
}