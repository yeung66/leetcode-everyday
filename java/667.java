class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        for (int i=0;i<n-k;i++) {
            ans[i]=i+1;
        }
        for (int i=0;n-k+i<n;i++){
            if (i%2==0) {
                ans[n-k+i]=n-i/2;
            } else {
                ans[n-k+i]=n-k + i/2 + 1;
            }
        }
        return ans;
    }
}