class Solution {
    public boolean isThree(int n) {
        int count = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                count++;
        }
        return count == 3;
    }
}