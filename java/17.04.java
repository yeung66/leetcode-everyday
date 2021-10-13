import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return IntStream.range(1, n + 1).reduce(0, (prev, x) -> prev ^ x ^ nums[x-1]);
    }
}