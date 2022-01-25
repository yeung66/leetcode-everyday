import java.util.*;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Set<Integer>> graph = new ArrayList<>();
        graph.add(null);
        for (int i = 1; i <= n; i++) {
            graph.add(new HashSet<>());
        }

        for (var e : edges) {
            int l = e[0], r = e[1];
            graph.get(l).add(r);
            graph.get(r).add(l);
        }

        int[][] dis = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[1][0] = 0;

        // no. time
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 1, 0 });
        while (dis[n][1] == Integer.MAX_VALUE) {
            var node = queue.poll();
            int idx = node[0], len = node[1];
            System.out.printf("%d %d\n", idx, len);

            for (var neigh : graph.get(idx)) {
                if (len + 1 < dis[neigh][0]) {
                    dis[neigh][0] = len + 1;
                    queue.offer(new int[] { neigh, len + 1 });
                } else if (len + 1 > dis[neigh][0] && len + 1 < dis[neigh][1]) {
                    dis[neigh][1] = len + 1;
                    queue.offer(new int[] { neigh, len + 1 });
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < dis[n][1]; i++) {
            ans += waitTime(ans, change) + time;
        }
        
        return ans;
    }
    
    public int waitTime(int time, int change) {
        int left = time % (2 * change);
        return left < change ? 0 : 2 * change - left;
    }
}

// 5
// [[1,2],[1,3],[1,4],[3,4],[4,5]]
// 3
// 5
// 2
// [[1,2]]
// 3
// 2