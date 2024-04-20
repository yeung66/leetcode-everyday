import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        ans = new ArrayList<>();
        dfs(target, new LinkedList<>(), 0);
        return ans;
    }

    int[] candidates;
    List<List<Integer>> ans;

    public void dfs(int target, Deque<Integer> prev, int idx) {
        if (idx == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(prev));
            return;
        }

        dfs(target, prev, idx + 1);
        if (target - candidates[idx] >= 0) {
            prev.add(candidates[idx]);
            dfs(target - candidates[idx], prev, idx);
            prev.removeLast();
        }
    }
}