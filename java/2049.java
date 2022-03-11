class Solution {
    int[] child1;
    int[] child2;
    int[] cnt;
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        child1 = new int[n];
        child2 = new int[n];
        cnt = new int[n];
        Arrays.fill(child1, -1);
        Arrays.fill(child2, -1);
        for (int i=1;i<n;i++) {
            if (child1[parents[i]] == -1) {
                child1[parents[i]] = i;
            } else {
                child2[parents[i]] = i;
            }           
        }

        dfs(0);
        long ans = 0;
        int cnt1 = 0;
        for (int i=0;i<n;i++) {
            long temp = 1;
            if (parents[i] != -1) {
                temp *= cnt[0] - cnt[i];
            }

            if (child1[i] != -1) {
                temp *= cnt[child1[i]];
                if (child2[i] != -1) {
                    temp *= cnt[child2[i]];
                }
            }
            // System.out.println(temp);
            if (temp == ans) cnt1++;
            else if (temp > ans) {
                cnt1 = 1;
                ans = temp;
                // System.out.println(temp);
            }
        }
        return cnt1;

    }

    public int dfs(int idx) {
        if (child1[idx] == -1) {
            cnt[idx] = 1;
            // System.out.println(idx);
        } else {
            cnt[idx] = 1 + dfs(child1[idx]) + (child2[idx] == -1 ? 0 : dfs(child2[idx]));
        }

        
        // System.out.printf("%d %d\n", idx, cnt[idx]);
        return cnt[idx];
    }

}

