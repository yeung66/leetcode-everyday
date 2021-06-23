import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String[] permutation(String s) {

        ans = new HashSet<>();
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[n];
        StringBuilder prev = new StringBuilder();
        permutation(n, 0, chars, prev, used);

        return ans.toArray(new String[1]);
    }

    private Set<String> ans;

    private void permutation(int n, int cur, char[] chars, StringBuilder prev, boolean[] used) {
        if (n == cur) {
            ans.add(prev.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                prev.append(chars[i]);
                permutation(n, cur + 1, chars, prev, used);
                prev.deleteCharAt(cur);
                used[i] = false;
            }
        }
    }
}