class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candies = new ArrayList<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '|') candies.add(i);
        }

        int[] ans = new int[queries.length];
        for (int i=0;i<queries.length;i++) {
            int[] q = queries[i];
            int left = q[0], right = q[1];
            int leftCanIdx = searchLeft(candies, left);
            int rightCanIdx = searchRight(candies, right);
            if (leftCanIdx == -1 || leftCanIdx == candies.size() || rightCanIdx == -1 || rightCanIdx == candies.size()) {
                ans[i] = 0;
            } else {
                int leftCan = candies.get(leftCanIdx), rightCan = candies.get(rightCanIdx);
                if (leftCan > right || leftCan < left || rightCan > right || rightCan < left || leftCan > rightCan) {
                    ans[i] = 0;
                } else {
                    ans[i] = rightCan - leftCan - 1 - (rightCanIdx - leftCanIdx - 1);
                }
            }
        }

        return ans;


    }

    public int searchLeft(List<Integer> candies, int target) {
        int l = 0, r = candies.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // System.out.println(mid);
            if (candies.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int searchRight(List<Integer> candies, int target) {
        int l = 0, r = candies.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (candies.get(mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}