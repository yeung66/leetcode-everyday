import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        IntStream.of(nums).forEach(i -> pq.add((long) i));
        long ans = 0;
        while (k-- > 0) {
            long point = pq.poll();
            long newPoint = (point + 2) / 3;
            pq.add(newPoint);
            ans += point;
        }

        return ans;
    }
}