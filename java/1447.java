// https://leetcode-cn.com/problems/simplified-fractions/submissions/

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i=2;i<=n;i++) {
            for (int j=1;j<i;j++) {
                if (gcd(i,j)==1) {
                    ans.add(j+"/"+i);
                }
            }
        }

        return ans;
    }

    public int gcd(int i, int j) {
        while (j != 0) {
            int temp = i;
            i = j;
            j = temp % j;
        }

        return i;
    }
}