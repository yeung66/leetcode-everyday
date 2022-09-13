class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i=0;i<n;i++) h[i] = i;

        Arrays.sort(h, (a, b) -> {
            return - wage[b] * quality[a] + wage[a] * quality[b];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        double totalq = 0;
        double ans = 1e9;
        for (int i=0;i<k-1;i++) {
            totalq += quality[h[i]];
            pq.offer(quality[h[i]]);
        }

        for (int i=k-1;i<n;i++) {
            int head = h[i];
            totalq += quality[head];
            pq.offer(quality[head]);
            
            double c = ((double) wage[head] / quality[head]) * totalq;
            ans = Math.min(ans, c);
            totalq -= pq.poll();
        }

        return ans;
    }
}