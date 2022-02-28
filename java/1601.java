class Solution {
    public int maximumRequests(int n, int[][] requests) {
        ans = 0;
        cnt = 0;
        delta = new int[n];
        dfs(requests, 0);

        return ans;
    }

    int ans, cnt;
    int[] delta;

    public void dfs(int[][] reqs, int idx) {
        if (idx == reqs.length) {
            if (check())
                ans = Math.max(ans, cnt);
            return;
        }

        dfs(reqs, idx + 1);

        int x = reqs[idx][0], y = reqs[idx][1];
        delta[x]--;
        delta[y]++;
        cnt++;
        dfs(reqs, idx + 1);
        delta[x]++;
        delta[y]--;
        cnt--;

    }
    
    public boolean check() {
        for (var i : delta) {
            if (i != 0)
                return false;
        }

        return true;
    }
}