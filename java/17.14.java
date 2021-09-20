import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        var stream = Arrays.stream(arr);
        return stream.sorted().limit(k).toArray();
    }
}