class Solution {
    public int trailingZeroes(int n) {
        // int fives = 0;
        // for (int i=1;i<=n;i++) {
        //     int temp = i;
        //     while (temp % 5 == 0) {
        //         temp /= 5;
        //         fives++;
        //     }
        // }

        // return fives;

        int cur = 5;
        int ans = 0;
        int times = n / 5;
        while (times > 0) {
            ans += times;
            times /= 5;
        }

        return ans;
    }
}