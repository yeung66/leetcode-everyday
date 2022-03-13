class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (var i:arr) {
            pq.offer(i);
        }

        int[] ans = new int[k];
        for (int i=0;i<k;i++) ans[i] = pq.poll();
        return ans;
    }
}