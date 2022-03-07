class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] ups = new int[n], downs = new int[n];
        for (int i=0;i<n;i++) {
            if (i > 0 && security[i] <= security[i-1]) {
                ups[i] = ups[i-1] + 1;
            } else {
                ups[i] = 1;
            }
        }

        for (int i=n-1;i>=0;i--) {
            if (i<n-1&& security[i] <= security[i+1]) {
                downs[i] = downs[i+1] + 1;
            } else {
                downs[i] = 1;
            }
        }

        if (time == 0) return IntStream.range(0, n).boxed().collect(Collectors.toList());

        List<Integer> ans = new ArrayList<>();
        for (int i = time;i + time < n;i++) {
            if (security[i]<=security[i-1]&&ups[i-1]>=time&&security[i]<=security[i+1]&&downs[i+1]>=time) {
                ans.add(i);
            }
        }

        return ans;
    }
}