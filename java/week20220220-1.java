class Solution {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            if (check(i)) {
                ans++;
            }
        }

        return ans;
    }

    public boolean check(int i) {
        int cnt = 0;
        while (i > 0) {
            cnt += i % 10;
            i /= 10;
        }

        return cnt % 2 == 0;
    }
}