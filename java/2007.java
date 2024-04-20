import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        Arrays.sort(changed);
        Map<Integer, Integer> existed = new HashMap<>();
        int[] ret = new int[changed.length / 2];
        int idx = 0;
        for (int i: changed) {
            if (existed.containsKey(i)) {
                ret[idx] = i / 2;
                idx++;
                if (existed.get(i) == 1) {
                    existed.remove(i);
                } else {
                    existed.put(i, existed.get(i) - 1);
                }
            } else {
                existed.put(2 * i, existed.getOrDefault(2 * i, 0) + 1);
            }
        }

        return existed.isEmpty() ? ret : new int[0];
    }
}