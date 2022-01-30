class DetectSquares {

    private int[][] points;

    public DetectSquares() {
        points = new int[1001][1001];
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        points[x][y]++;
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i != y && points[x][i] > 0) {
                int width = Math.abs(i - x);
                System.out.println(width);
                if (x - width >= 0) {
                    ans += points[x][i] * points[x - width][i] * points[x - width][y];
                }

                if (x + width <= 1000) {
                    ans += points[x][i] * points[x + width][i] * points[x + width][y];
                }
            }
        }

        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */