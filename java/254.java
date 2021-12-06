import java.util.*;

class Solution {
    public List<List<Integer>> getFactors(int n) {
        return dfs(n, 2);
    }

    public List<List<Integer>> dfs(int n, int l) {
        int bound = (int) Math.sqrt(n);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = l; i < bound + 1; i++) {
            if (n % i == 0) {
                List<Integer> a = new ArrayList<>();
                a.add(i);
                a.add(n / i);
                ans.add(a);

                for (List<Integer> prev : dfs(n / i, i)) {
                    prev.add(0, i);
                    ans.add(prev);
                }

            }

        }

        return ans;

    }
}