// can optimize
class Solution {
    int[] set;
    int find(int idx) {
        // int idx = 2 * n + y;
        if (idx==set[idx]) return idx;

        int a = set[idx];
        while (a != set[a]) {
            a = set[a];
        }

        int b = idx;
        while (a != set[b]) {
            set[b] = a;
            b = set[b];
        }

        return a;
    }

    void union(int i1, int i2) {
        set[i1] = find(i2);
    }

    int[][] grid;
    int n;
    int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    Map<Integer, Integer> cnt;

    public void dfs(int x, int y) {
        for (int[] d:directions) {
            int xx = x + d[0], yy = y + d[1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < n && grid[xx][yy] == 1 && find(n*xx+yy) != find(n*x+y)) {
                union(n*xx+yy,n*x+y);
                dfs(xx,yy);
            }
        }
    }

    public int tryTran(int x, int y) {
        int ret = 0;
        Set<Integer> visited = new HashSet<>();
        for (int[] d:directions) {
            int xx = x + d[0], yy = y + d[1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < n && grid[xx][yy] == 1 && !visited.contains(find(n*xx+yy))) {
                ret += cnt.get(find(n*xx+yy));
                visited.add(find(n*xx+yy));
            }
        }

        return ret + 1;
    }

    public int largestIsland(int[][] grid) {
        n = grid.length;
        set = new int[n * n + 10];
        this.grid = grid;
        for (int i=0;i<set.length;i++) {
            set[i] = i;
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) dfs(i,j);
            }
        }

        cnt =  new HashMap<>();
        int ans = 0;
        for (int i=0;i<set.length;i++) {
            cnt.put(find(i), cnt.getOrDefault(find(i), 0) + 1);
            ans = Math.max(ans, cnt.get(find(i)));
        }
        
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(tryTran(i,j), ans);
                }
            }
        }
        return ans;
    }
}