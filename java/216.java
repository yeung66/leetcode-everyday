import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        this.k = k;
        dfs(n, 1, new ArrayDeque<>());
        return ans;
    }

    List<List<Integer>> ans;
    int k;

    void dfs(int target, int idx, Deque<Integer> path) {
        if (target == 0) {
            if (path.size() == k)
                ans.add(new ArrayList<>(path));
            return;
        }
        
        if (idx == 10 || path.size() > k) return;
        

        dfs(target, idx + 1, path);

        if (idx <= target && path.size() < k) {
            path.add(idx);
            dfs(target - idx, idx + 1, path);
            path.removeLast();
        }
    }
}