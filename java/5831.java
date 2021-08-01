class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for (var m : milestones) {
            sum += m;
            max = Math.max(max, m);
        }

        if (max > sum - max + 1)
            return (sum - max) * 2 + 1;
        return sum;
    }
}