class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0, idx = 0, n = tickets.length;
        while (tickets[k] > 0) {
            if (tickets[idx] != 0) {
                tickets[idx]--;
                ans++;
            }

            idx = (idx + 1) % n;
            
            if (tickets[k] == 0)
                break;
        }

        return ans;
        
    }
}