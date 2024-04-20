import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        added = new HashSet<>();
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return added.stream().map(i ->
                Arrays.stream(i.split(","))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    Set<String> added;

    public void dfs(int[] candidates, int target, List<Integer> prev, int cnt, int idx) {
        if (cnt == target) {
            String ansStr = prev.stream().map(Object::toString).collect(Collectors.joining(","));
            added.add(ansStr);
        }
        ;
        if (idx == candidates.length) return;
        int times = 0;
        for (; times * candidates[idx] + cnt <= target; times++) {
            if (times > 0) prev.add(candidates[idx]);
            dfs(candidates, target, prev, cnt + times * candidates[idx], idx + 1);
        }

        for (; times > 1; times--) prev.remove(prev.size() - 1);
    }
}