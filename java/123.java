class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cnt=0,start=0;
        int n=gas.length;
        while (cnt<n) {
            int left=0;
            boolean found = true;
            for (int i=0;i<n;i++) {
                left += gas[(i+start)%n]-cost[(i+start)%n];
                if (left<0) {
                    start = (i + start+1) % n;
                    cnt += 1;
                    found = false;
                    break;
                }
            }
            if (found) return start;
        }

        return cnt==n?-1:start;
    }
}