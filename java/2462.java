import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        if (candidates * 2 >= n) {
            return Arrays.stream(costs).sorted().limit(k).sum();
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int left = 0, right = n - 1;
        for (;left<candidates;left++,right--) {
            pq.offer(new int[]{costs[left], left});
            pq.offer(new int[]{costs[right], right});
        }

        long ret = 0;
        for (;k>0;k--) {
            int[] ele = pq.poll();
            int cost = ele[0], idx = ele[1];
            ret += cost;

            if (idx < left && left <= right) {
                pq.offer(new int[]{costs[left], left});
                left++;
            } else if (idx > right && left <= right) {
                pq.offer(new int[]{costs[right], right});
                right--;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{25,65,41,31,14,20,59,42,43,57,73,45,30,77,17,38,20,11,17,65,55,85,74,32,84};
        long cost = (new Solution()).totalCost(costs, 24, 8);
    }
}