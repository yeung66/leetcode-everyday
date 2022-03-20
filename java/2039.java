class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length - 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for (int[] e:edges) {
            int x = e[0], y = e[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[] dis = new int[n+1];
        boolean[] checked = new boolean[n+1];
        Arrays.fill(dis, 100001);
        Queue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        pq.offer(new int[]{0,0});
        for (int i=0;i<=n;) {
            int[] pair = pq.poll();
            int cur = pair[1], minDis = pair[0];
            if (checked[cur]) continue;
            i++;
            checked[cur] = true;
            dis[cur] = minDis;
            for (var nei: graph.get(cur)) {
                if (!checked[nei] && 1 + minDis < dis[nei]) {
                    pq.offer(new int[] {1 + minDis, nei});
                    dis[nei] = 1 + minDis;
                }
            }
            
        }

        int ans = 0;
        for (int i=1;i<=n;i++) {
            int cost = dis[i] * 2;
            if (patience[i] >= cost) ans = Math.max(ans, cost);
            else {
                int k = 1;
                while (k * patience[i] < cost) k++;
                ans = Math.max(ans, (k-1)*patience[i] + cost);
            }
        }
        
        return ans + 1;

    }
}