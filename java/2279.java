class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] diffs=new int[n];
        Queue<Integer> pq = new PriorityQueue<>();
        int res=0;
        for (int i=0;i<n;i++) {
            if (rocks[i]<capacity[i]) pq.offer(capacity[i]-rocks[i]);
            else res++;
        }

        while(additionalRocks>0&&!pq.isEmpty()){
            int diff=pq.poll();
            if (additionalRocks>=diff){
                res++;
                additionalRocks=additionalRocks-diff;
            } else {
                break;
            }
        }
        return res;
    }
}