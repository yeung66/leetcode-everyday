class Solution {
    public int kSimilarity(String s1, String s2) {
        n = s1.length();
        chars = s1.toCharArray();
        ans = 19;
        search(0,0,s1,s2);
        return ans;
    }

    int n;
    char[] chars;
    int ans;

    public int minSwap(String s1, String s2, int pos) {
        int tot = 0;
        for (int i = pos; i < s1.length(); i++) {
            tot += chars[i] != s2.charAt(i) ? 1 : 0;
        }
        return (tot + 1) / 2;
    }

    public void search(int idx, int k, String s1, String s2) {
        if (k > ans) return;

        while (idx < n && chars[idx]==s2.charAt(idx)) {
            idx++;
        }

        if (idx == n) {
            ans = Math.min(ans, k);
            return;
        }

        if (minSwap(s1,s2,idx) + k >= ans) {
            return;
        }


        for (int i=idx+1;i<n;i++) {
            if (chars[i] == s2.charAt(idx) && chars[i] != s2.charAt(i)) {
                char temp = chars[idx];
                chars[idx] = chars[i];
                chars[i] = temp;

                search(idx+1,k+1,s1,s2);
                temp = chars[idx];

                chars[idx] = chars[i];
                chars[i] = temp;
            }
        }
        
    }
}