class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> cnt = new HashMap<>();
        Set<Integer> used = new HashSet<>();
        int ans = 0;
        for (var i:nums) {
            if (used.contains(i)) continue;
            used.add(i);
            if (cnt.containsKey(i - 1) && cnt.containsKey(i + 1)) {
                int[] range1 = cnt.get(i-1);
                int[] range2 = cnt.get(i+1);
                cnt.remove(i-1);
                cnt.remove(i+1);
                int[] newRange = new int[]{range1[0], range2[1]};
                
                cnt.put(newRange[0], newRange);
                cnt.put(newRange[1], newRange);

                // System.out.printf("%d: %d %d \n", i, newRange[0], newRange[1]);
            }

            else if (cnt.containsKey(i - 1)) {
                int[] range = cnt.get(i - 1);
                if (range[1] == i - 1) {
                    range[1] = i;
                    cnt.put(i, range);
                    cnt.remove(i - 1);
                    cnt.put(range[0], range);

                    // System.out.printf("%d: %d %d \n",i, range[0], range[1]);
                } 
            } else if (cnt.containsKey(i + 1)) {
                int[] range = cnt.get(i + 1);
                if (range[0] == i + 1) {
                    range[0] = i;
                    cnt.put(i, range);
                    cnt.remove(i + 1);
                    cnt.put(range[1], range);

                    // System.out.printf("%d: %d %d \n",i, range[0], range[1]);
                }
            } else if (!cnt.containsKey(i)) {
                cnt.put(i, new int[]{i, i});

                // System.out.printf("%d %d \n", i, i);
            }
        }

        for (int[] val: cnt.values()) {
            ans = Math.max(ans, val[1] - val[0] + 1);
        }

        return ans;
    }
}